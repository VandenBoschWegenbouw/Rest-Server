package com.fontys.logic.handlers;

import com.fontys.dal.services.CompanyService;
import com.fontys.domain.interfaces.CRUD;
import com.fontys.domain.models.Company;
import com.fontys.logic.components.CompanyComponent;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CompanyHandler implements CRUD<Company, Long> {
    @Setter
    private CompanyService service;

    @Setter
    private CompanyComponent component;

    public CompanyHandler() {
    }

    @Autowired
    public CompanyHandler(CompanyService service, CompanyComponent component) {
        this.service = service;
        this.component = component;
    }


    @Override
    public Company create(Company entity) {
        return service.create(entity);
    }

    @Override
    public Company read(Long id) {
        return service.read(id);
    }

    @Override
    public Iterable<Company> readAll() {
        return service.readAll();
    }

    @Override
    public Company update(Company entity) {
        return service.update(entity);
    }

    @Override
    public boolean delete(Long id) {
        return service.delete(id);
    }
}
