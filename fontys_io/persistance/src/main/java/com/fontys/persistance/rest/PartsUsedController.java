package com.fontys.persistance.rest;

import com.fontys.domain.interfaces.RESTCRUD;
import com.fontys.domain.models.PartsUsed;
import com.fontys.logic.handlers.PartsUsedHandler;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/partsused/")
public class PartsUsedController implements RESTCRUD<PartsUsed, Long> {

    @Setter
    private PartsUsedHandler handler;

    public PartsUsedController() {
    }

    @Autowired
    public PartsUsedController(PartsUsedHandler handler) {
        this.handler = handler;
    }

    @Override
    public PartsUsed create(PartsUsed entity) {
        return handler.create(entity);
    }

    @Override
    public PartsUsed update(PartsUsed entity) {
        return handler.update(entity);
    }

    @Override
    public boolean delete(Long id) {
        return handler.delete(id);
    }

    @RequestMapping(value = "{date}", method = RequestMethod.GET)
    public Iterable<PartsUsed> readByDate(@PathVariable("date") Date date){
        return handler.readByDate(date);
    }
}
