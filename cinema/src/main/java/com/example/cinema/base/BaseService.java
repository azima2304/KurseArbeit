package com.example.cinema.base;

import com.example.cinema.exceptions.OperationFailed;
import com.example.cinema.utils.Language;

import java.util.List;

public interface BaseService <Dt extends BaseDto>  {
    Dt save(Dt dt);
    Dt findById(Long id, Language language);
    List<Dt> findAll();
    Dt update(Dt dt);
    boolean delete(Dt dt, Language language) throws OperationFailed;


}
