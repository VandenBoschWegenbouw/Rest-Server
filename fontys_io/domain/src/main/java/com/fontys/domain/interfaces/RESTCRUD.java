package com.fontys.domain.interfaces;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

public interface RESTCRUD<T, R> {

    @RequestMapping(value = "", method = RequestMethod.POST)
    T create(@RequestBody T entity);

    @RequestMapping(value = "", method = RequestMethod.PUT)
    T update(@RequestBody T entity);

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    boolean delete(@PathVariable("id") R id);

}