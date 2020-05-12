package com.fontys.dal.services;

import com.fontys.dal.repositories.PartTypeRepository;
import com.fontys.domain.interfaces.CRUD;
import com.fontys.domain.models.PartType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class PartTypeService implements CRUD<PartType, Long> {

    @Autowired
    @Qualifier("PartTypeRepository")
    private PartTypeRepository repository;

    @Override
    public PartType create(PartType entity) {
        return repository.save(entity);
    }

    @Override
    public PartType read(Long id) {
        return repository.findById(id).get();
    }

    @Override
    public Iterable<PartType> readAll() {
        return repository.findAll();
    }

    @Override
    public PartType update(PartType entity) {
        return repository.save(entity);
    }

    @Override
    public boolean delete(Long id) {
        repository.deleteById(id);
        return true;
    }
}
