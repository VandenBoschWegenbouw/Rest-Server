package com.fontys.dal.services;

import com.fontys.dal.repositories.HourRegistrationRepository;
import com.fontys.domain.interfaces.CRUD;
import com.fontys.domain.models.HourRegistration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.LocalDateTime;
import java.time.LocalTime;


@Service
public class HourRegistrationService implements CRUD<HourRegistration, Long> {


    @Autowired
    @Qualifier("HourRegistrationRepository")
    private HourRegistrationRepository repository;

    @Override
    public HourRegistration create(HourRegistration entity) {
        return repository.save(entity);
    }

    @Override
    public HourRegistration read(Long id) {
        return repository.findById(id).get();
    }

    @Override
    public Iterable<HourRegistration> readAll() {
        return repository.findAll();
    }

    @Override
    public HourRegistration update(HourRegistration entity) {
        return repository.save(entity);
    }

    @Override
    public boolean delete(Long id) {
        repository.deleteById(id);
        return true;
    }

    public Iterable<HourRegistration> readByDateAndUserId(Date date, Long id) {
        return repository.findAllByDateAndUserId(LocalDateTime.of(date.toLocalDate(), LocalTime.MIN), LocalDateTime.of(date.toLocalDate(), LocalTime.MAX), id);
    }
}
