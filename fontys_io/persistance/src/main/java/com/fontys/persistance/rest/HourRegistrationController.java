package com.fontys.persistance.rest;

import com.fontys.domain.interfaces.RESTCRUD;
import com.fontys.domain.models.HourRegistration;
import com.fontys.logic.handlers.HourRegistrationHandler;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;


@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/hourregistration/")
public class HourRegistrationController implements RESTCRUD<HourRegistration, Long> {

    @Setter
    private HourRegistrationHandler handler;

    public HourRegistrationController() {
    }

    @Autowired
    public HourRegistrationController(HourRegistrationHandler handler) {
        this.handler = handler;
    }

    @Override
    public HourRegistration create(HourRegistration entity) {
        return handler.create(entity);
    }

    @Override
    public HourRegistration update(HourRegistration entity) {
        return handler.update(entity);
    }

    @Override
    public boolean delete(Long id) {
        return handler.delete(id);
    }

    @RequestMapping(value = "{date}/{id}", method = RequestMethod.GET)
    public Iterable<HourRegistration> readByDate(@PathVariable("date") Date date, @PathVariable("id") Long id){
        return handler.readByDateAndUserId(date, id);
    }



}
