package com.fontys.dal.services;

import com.fontys.dal.repositories.PartsUsedRepository;
import com.fontys.domain.interfaces.CRUD;
import com.fontys.domain.models.PartsUsed;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Service
public class PartsUsedService implements CRUD<PartsUsed, Long> {

    @Autowired
    @Qualifier("PartsUsedRepository")
    private PartsUsedRepository repository;

    @Override
    public PartsUsed create(PartsUsed entity) {
        return repository.save(entity);
    }

    @Override
    public PartsUsed read(Long id) {
        return repository.findById(id).get();
    }

    @Override
    public Iterable<PartsUsed> readAll() {
        return repository.findAll();
    }

    @Override
    public PartsUsed update(PartsUsed entity) {
        return repository.save(entity);
    }

    @Override
    public boolean delete(Long id) {
        repository.deleteById(id);
        return true;
    }

    public Iterable<PartsUsed> readByDate(Date date) {
        return repository.findAllByDate(LocalDateTime.of(date.toLocalDate(), LocalTime.MIN), LocalDateTime.of(date.toLocalDate(), LocalTime.MAX));
    }
}
