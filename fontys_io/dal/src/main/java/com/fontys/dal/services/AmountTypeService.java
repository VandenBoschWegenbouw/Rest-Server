package com.fontys.dal.services;

import com.fontys.dal.repositories.AmountTypeRepository;
import com.fontys.domain.interfaces.CRUD;
import com.fontys.domain.models.AmountType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class AmountTypeService implements CRUD<AmountType, Long> {
    @Autowired
    @Qualifier("AmountTypeRepository")
    private AmountTypeRepository repository;

    @Override
    public AmountType create(AmountType entity) {
        return repository.save(entity);
    }

    @Override
    public AmountType read(Long id) {
        return repository.findById(id).get();
    }

    @Override
    public Iterable<AmountType> readAll() {
        return repository.findAll();
    }

    @Override
    public AmountType update(AmountType entity) {
        return repository.save(entity);
    }

    @Override
    public boolean delete(Long id) {
        repository.deleteById(id);
        return true;
    }
}
