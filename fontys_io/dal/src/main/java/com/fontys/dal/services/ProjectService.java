package com.fontys.dal.services;

import com.fontys.dal.repositories.ProjectRepository;
import com.fontys.domain.interfaces.CRUD;
import com.fontys.domain.models.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class ProjectService implements CRUD<Project, Long> {
    @Autowired
    @Qualifier("ProjectRepository")
    private ProjectRepository repository;

    @Override
    public Project create(Project entity) {
        return repository.save(entity);
    }

    @Override
    public Project read(Long id) {
        return repository.findById(id).get();
    }

    @Override
    public Iterable<Project> readAll() {
        return repository.findAll();
    }

    @Override
    public Project update(Project entity) {
        return repository.save(entity);
    }

    @Override
    public boolean delete(Long id) {
        repository.deleteById(id);
        return true;
    }
}
