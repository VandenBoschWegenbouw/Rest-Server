package com.fontys.logic.handlers;

import com.fontys.dal.services.PartsUsedService;
import com.fontys.domain.interfaces.CRUD;
import com.fontys.domain.models.PartsUsed;
import com.fontys.logic.components.PartsUsedComponent;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Date;

@Component
public class PartsUsedHandler implements CRUD<PartsUsed, Long> {
    @Setter
    private PartsUsedService service;

    @Setter
    private PartsUsedComponent component;

    public PartsUsedHandler() {
    }

    @Autowired
    public PartsUsedHandler(PartsUsedService service, PartsUsedComponent component) {
        this.service = service;
        this.component = component;
    }


    @Override
    public PartsUsed create(PartsUsed entity) {
        return service.create(entity);
    }

    @Override
    public PartsUsed read(Long id) {
        return service.read(id);
    }

    @Override
    public Iterable<PartsUsed> readAll() {
        return service.readAll();
    }

    @Override
    public PartsUsed update(PartsUsed entity) {
        return service.update(entity);
    }

    @Override
    public boolean delete(Long id) {
        return service.delete(id);
    }


    public Iterable<PartsUsed> readByDate(Date date) {
        return service.readByDate(date);
    }
}
