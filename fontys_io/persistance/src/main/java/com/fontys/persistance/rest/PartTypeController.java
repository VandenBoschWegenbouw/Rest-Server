package com.fontys.persistance.rest;

import com.fontys.domain.interfaces.RESTCRUD;
import com.fontys.domain.models.AmountType;
import com.fontys.domain.models.PartType;
import com.fontys.logic.handlers.PartTypeHandler;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/parttypes/")
public class PartTypeController implements RESTCRUD<PartType, Long> {

    @Setter
    private PartTypeHandler handler;

    public PartTypeController() {
    }

    @Autowired
    public PartTypeController(PartTypeHandler handler) {
        this.handler = handler;
    }

    @Override
    public PartType create(PartType entity) {
        return handler.create(entity);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    public PartType read(@PathVariable("id") Long id) {
        return handler.read(id);
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public Iterable<PartType> readAll() {
        return handler.readAll();
    }

    @Override
    public PartType update(PartType entity) {
        return handler.update(entity);
    }

    @Override
    public boolean delete(Long id) {
        return handler.delete(id);
    }
}
