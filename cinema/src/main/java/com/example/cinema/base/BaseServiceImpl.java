package com.example.cinema.base;

import com.example.cinema.CycleAvoidingMappingContext;
import com.example.cinema.exceptions.DeleteException;
import com.example.cinema.exceptions.NotFoundByIDException;
import com.example.cinema.exceptions.OperationFailed;
import com.example.cinema.models.dto.CinemaDto;
import com.example.cinema.utils.Language;
import com.example.cinema.utils.ResourceBundle;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;


public class BaseServiceImpl<E extends BaseEntity,
        Dt extends BaseDto, M extends BaseMapper<E, Dt>,
        R extends BaseRepo<E>> implements BaseService<Dt> {

    public BaseServiceImpl(R rep, M m) {
        this.rep = rep;
        this.m = m;
    }

    protected final   R rep;
    protected final M m;

    @Autowired
    protected CycleAvoidingMappingContext context;
    @Override
    public Dt save(Dt dt) {
        return m.toDto(rep.save(m.toEntity(dt,context)),context);
    }


    @Override
    public Dt findById(Long id, Language language) {
        return m.toDto(rep.findById(id).orElseThrow(()->new NotFoundByIDException(ResourceBundle.periodMessages("notFoundById",language))), context);
    }

    @Override
    public List<Dt> findAll() {
        return m.toDtoList(rep.findAll(), context);
    }


    @Override
    public Dt update(Dt dt) {
        return m.toDto(rep.saveAndFlush(m.toEntity(dt,context)),context);
    }

    @Override
    public boolean delete(Dt dt, Language language){
        try {
            rep.delete(m.toEntity(dt, context));
            return true;
        }  catch (Exception exception) {
            throw new DeleteException(ResourceBundle.periodMessages("failedToDelete", language));
        }
    }


}
