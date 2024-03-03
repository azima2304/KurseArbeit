package com.example.cinema.service.impl;

import com.example.cinema.utils.Language;
import com.example.cinema.base.BaseServiceImpl;
import com.example.cinema.exceptions.AgeException;
import com.example.cinema.exceptions.NotFoundByIDException;
import com.example.cinema.exceptions.RowAndPlaceException;
import com.example.cinema.exceptions.SessionCantBeException;
import com.example.cinema.models.dto.*;
import com.example.cinema.models.dto.request.OrderSessionSeatsCreateRequest;
import com.example.cinema.models.dto.request.SeatsRequest;
import com.example.cinema.models.dto.response.OrderSessionSeatsRespose;
import com.example.cinema.models.dto.response.Response;
import com.example.cinema.models.entity.*;
import com.example.cinema.models.enums.PriceType;
import com.example.cinema.models.mappers.OrderMapper;
import com.example.cinema.models.mappers.OrderSessionSeatsMapper;
import com.example.cinema.models.mappers.SessionSeatsMapper;
import com.example.cinema.repo.*;
import com.example.cinema.service.OrderService;
import com.example.cinema.service.OrderSessionSeatsService;
import com.example.cinema.utils.ResourceBundle;
import org.springframework.stereotype.Service;

import org.springframework.mail.javamail.JavaMailSender;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderSessionSeatsServiceImpl extends BaseServiceImpl<OrderSessionSeats, OrderSessionSeatsDto, OrderSessionSeatsMapper, OrderSessionSeatsRepo> implements OrderSessionSeatsService {

    private final OrderService orderService;
    private final SessionRepo sessionRepo;
    private final SeatsRepo seatsRepo;
    private final SessionSeatsRepo sessionSeatsRepo;
    private final JavaMailSender javaMailSender;

    public OrderSessionSeatsServiceImpl(OrderSessionSeatsRepo rep, OrderSessionSeatsMapper orderSessionSeatsMapper, OrderRepo orderRepo, OrderService orderService, SessionRepo sessionRepo, SeatsRepo seatsRepo, SessionSeatsRepo sessionSeatsRepo, JavaMailSender javaMailSender) {
        super(rep, orderSessionSeatsMapper);
        this.orderService = orderService;
        this.sessionRepo = sessionRepo;
        this.seatsRepo = seatsRepo;
        this.sessionSeatsRepo = sessionSeatsRepo;
        this.javaMailSender = javaMailSender;
    }


    @Override
    public OrderSessionSeatsRespose create(OrderSessionSeatsCreateRequest request, Language language) {
        OrderSessionSeats orderSessionSeatsDto = new OrderSessionSeats();
        OrderSessionSeatsRespose response = new OrderSessionSeatsRespose();

        List<SeatsRequest> takenSeats = new ArrayList<>();
        int totalPrices = 0;

        for (SeatsRequest item : request.getSeats()) {
                Long idSession = request.getIdSession();
                int row = item.getRow();
                if (row==0 || row<0){
                    throw new RowAndPlaceException(ResourceBundle.periodMessages("rowEx", language));
                }
                int place = item.getPlace();
                if (place==0 || place<0){
                    throw new RowAndPlaceException(ResourceBundle.periodMessages("placeEx", language));
                }
                PriceType type = item.getType();


                Session session = sessionRepo.findSessionById(idSession);
                if (session==null){
                    throw new NotFoundByIDException(ResourceBundle.periodMessages("notFoundById", language));
                }




                if (type == PriceType.ADULTS){
                    int resultPrice  = session.getPrice();
                    totalPrices+=resultPrice;
                }
                else if (type == PriceType.CHILDREN) {
                    if (session.getFilm().getAge() > 16) {
                        throw new AgeException(ResourceBundle.periodMessages("ageChild", language));
                    }
                    int resultPrice = session.getPriceForChild();
                    totalPrices += resultPrice;
                }


                Seats seat = seatsRepo.findSeatsByRowAndPlace(row, place, session.getHall().getId());
                if (seat==null){
                    throw new RowAndPlaceException(ResourceBundle.periodMessages("seatNot", language));
                }


//                Long idHallSeat = seat.getHall().getId();
//                Long hallIdSession = session.getHall().getId();
//                if (hallIdSession.equals(idHallSeat)) {
//                    throw new SessionCantBeException(ResourceBundle.periodMessages("dontHaveSession", language));
//                }

                if (seat.isBooked()) {
                    throw new RowAndPlaceException(ResourceBundle.periodMessages("seatisOccupied", language));
                }

                seat.setBooked(true);
                SessionSeats existingSessionSeats = sessionSeatsRepo.findBySessionAndSeat(session, seat);

                if (existingSessionSeats == null) {
                    SessionSeatsDto newSessionSeatsDto = new SessionSeatsDto();
                    newSessionSeatsDto.setSession(session);
                    newSessionSeatsDto.setSeat(seat);
                    newSessionSeatsDto.setPriceType(type);
                    SessionSeats sessionSeats = sessionSeatsRepo.save(SessionSeatsMapper.MAPPER.toEntity(newSessionSeatsDto, context));

                    orderSessionSeatsDto.setSeatsSession(sessionSeats);

                    SeatsRequest takenSeat = new SeatsRequest();
                    takenSeat.setRow(row);
                    takenSeat.setPlace(place);
                    takenSeat.setType(type);

                    takenSeats.add(takenSeat);

                } else {
                    throw new RowAndPlaceException(ResourceBundle.periodMessages("seatisOccupied", language));
                }

                OrderDto orderDto = new OrderDto();
                orderDto.setClientEmail(request.getClientEmail());
                orderDto.setTotalPrice(totalPrices);

                orderService.save(orderDto);
                orderSessionSeatsDto.setOrder(OrderMapper.MAPPER.toEntity(orderDto, context));

                response.setFilmName(session.getFilm().getName());
                response.setCinemaName(session.getHall().getCinema().getName());
                response.setHallName(session.getHall().getName());
                response.setSeats(takenSeats);
                response.setTotalPrice(totalPrices);
                response.setClientEmail(request.getClientEmail());

                new Response(ResourceBundle.periodMessages("created", language));
        }

        save(OrderSessionSeatsMapper.MAPPER.toDto(orderSessionSeatsDto, context));
        return response;
    }


}


