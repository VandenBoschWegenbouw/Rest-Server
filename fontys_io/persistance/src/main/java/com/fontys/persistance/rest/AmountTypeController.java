package com.fontys.persistance.rest;

import com.fontys.domain.interfaces.RESTCRUD;
import com.fontys.domain.models.AmountType;
import com.fontys.logic.handlers.AmountTypeHandler;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/amounttypes/")
public class AmountTypeController implements RESTCRUD<AmountType, Long> {

    @Setter
    private AmountTypeHandler handler;

    public AmountTypeController() {
    }

    @Autowired
    public AmountTypeController(AmountTypeHandler handler) {
        this.handler = handler;
    }

    @Override
    public AmountType create(AmountType entity) {
        return handler.create(entity);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    public AmountType read(@PathVariable("id") Long id) {
        return handler.read(id);
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public Iterable<AmountType> readAll() {
        return handler.readAll();
    }

    @Override
    public AmountType update(AmountType entity) {
        return handler.update(entity);
    }

    @Override
    public boolean delete(Long id) {
        return handler.delete(id);
    }
}
