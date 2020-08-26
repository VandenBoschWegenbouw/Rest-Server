package com.fontys.persistance.rest;

import com.fontys.domain.interfaces.RESTCRUD;
import com.fontys.domain.models.AmountType;
import com.fontys.domain.models.HourRegistration;
import com.fontys.domain.models.Project;
import com.fontys.logic.handlers.ProjectHandler;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/projects/")
public class ProjectController implements RESTCRUD<Project,Long> {
    @Setter
    private ProjectHandler handler;

    public ProjectController() {
    }

    @Autowired
    public ProjectController(ProjectHandler handler) {
        this.handler = handler;
    }

    @Override
    public Project create(Project entity) {
        return handler.create(entity);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    public Project read(@PathVariable("id") Long id) {
        return handler.read(id);
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public Iterable<Project> readAll() {
        return handler.readAll();
    }

    @Override
    public Project update(Project entity) {
        return handler.update(entity);
    }

    @Override
    public boolean delete(Long id) {
        return handler.delete(id);
    }

    @RequestMapping(value = "{id}/export", method = RequestMethod.GET)
    public Iterable<HourRegistration> readByDateAndProject(@PathVariable("id") Long id){
        return handler.readAndExport(id);
    }

    @RequestMapping(value = "{id}/close", method = RequestMethod.GET)
    public Boolean closeProject(@PathVariable("id") Long id){
        return handler.close(id);
    }
}
