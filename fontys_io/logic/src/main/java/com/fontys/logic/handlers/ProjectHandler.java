package com.fontys.logic.handlers;

import com.fontys.dal.services.ProjectService;
import com.fontys.domain.interfaces.CRUD;
import com.fontys.domain.models.Project;
import com.fontys.logic.components.ProjectComponent;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProjectHandler implements CRUD<Project, Long> {
    @Setter
    private ProjectService service;

    @Setter
    private ProjectComponent component;

    public ProjectHandler() {
    }

    @Autowired
    public ProjectHandler(ProjectService service, ProjectComponent component) {
        this.service = service;
        this.component = component;
    }


    @Override
    public Project create(Project entity) {
        return service.create(entity);
    }

    @Override
    public Project read(Long id) {
        return service.read(id);
    }

    @Override
    public Iterable<Project> readAll() {
        return service.readAll();
    }

    @Override
    public Project update(Project entity) {
        return service.update(entity);
    }

    @Override
    public boolean delete(Long id) {
        return service.delete(id);
    }
}
