package com.fontys.persistance.rest;

import com.fontys.domain.interfaces.RESTCRUD;
import com.fontys.domain.models.AmountType;
import com.fontys.domain.models.Company;
import com.fontys.logic.handlers.CompanyHandler;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/companies/")
public class CompanyController implements RESTCRUD<Company, Long> {

    @Setter
    private CompanyHandler handler;

    public CompanyController() {
    }

    @Autowired
    public CompanyController(CompanyHandler handler) {
        this.handler = handler;
    }

    @Override
    public Company create(Company entity) {
        return handler.create(entity);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    public Company read(@PathVariable("id") Long id) {
        return handler.read(id);
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public Iterable<Company> readAll() {
        return handler.readAll();
    }

    @Override
    public Company update(Company entity) {
        return handler.update(entity);
    }

    @Override
    public boolean delete(Long id) {
        return handler.delete(id);
    }
}
