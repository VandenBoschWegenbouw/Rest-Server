package com.fontys.dal.services;

import com.fontys.dal.repositories.CompanyRepository;
import com.fontys.domain.interfaces.CRUD;
import com.fontys.domain.models.Company;
import com.fontys.domain.models.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class CompanyService implements CRUD<Company, Long> {

    @Autowired
    @Qualifier("CompanyRepository")
    private CompanyRepository repository;

    @Override
    public Company create(Company entity) {
        return repository.save(entity);
    }

    @Override
    public Company read(Long id) {
        return repository.findById(id).get();
    }

    @Override
    public Iterable<Company> readAll() {
        return repository.findAll();
    }

    @Override
    public Company update(Company entity) {
        return repository.save(entity);
    }

    @Override
    public boolean delete(Long id) {
        repository.deleteById(id);
        return true;
    }

    public Iterable<Project> readByCompany(Long id) {
        return repository.readByCompany(id);
    }
}
