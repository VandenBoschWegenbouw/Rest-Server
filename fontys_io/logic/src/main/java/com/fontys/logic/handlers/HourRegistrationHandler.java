package com.fontys.logic.handlers;

import com.fontys.dal.services.HourRegistrationService;
import com.fontys.domain.interfaces.CRUD;
import com.fontys.domain.models.HourRegistration;
import com.fontys.logic.components.HourRegistrationComponent;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Date;

@Component
public class HourRegistrationHandler implements CRUD<HourRegistration, Long> {
    @Setter
    private HourRegistrationService service;

    @Setter
    private HourRegistrationComponent component;

    public HourRegistrationHandler() {
    }

    @Autowired
    public HourRegistrationHandler(HourRegistrationService service, HourRegistrationComponent component) {
        this.service = service;
        this.component = component;
    }


    @Override
    public HourRegistration create(HourRegistration entity) {
        return service.create(entity);
    }

    @Override
    public HourRegistration read(Long id) {
        return service.read(id);
    }

    @Override
    public Iterable<HourRegistration> readAll() {
        return service.readAll();
    }

    @Override
    public HourRegistration update(HourRegistration entity) {
        return service.update(entity);
    }

    @Override
    public boolean delete(Long id) {
        return service.delete(id);
    }

    public Iterable<HourRegistration> readByDateAndUserId(Date date, Long id) {
        return service.readByDateAndUserId(date,id);
    }

    public Iterable<HourRegistration> readByDateAndProjectId(Date date, Long id) {
        return service.readByDateAndProjectId(date,id);
    }
}
