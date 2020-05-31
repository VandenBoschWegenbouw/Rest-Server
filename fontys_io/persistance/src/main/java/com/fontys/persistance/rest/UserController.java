package com.fontys.persistance.rest;

import com.fontys.domain.interfaces.RESTCRUD;
import com.fontys.domain.models.User;
import com.fontys.logic.handlers.UserHandler;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/users/")
public class UserController implements RESTCRUD<User, Long> {

    @Setter
    private UserHandler handler;

    public UserController() {
    }

    @Autowired
    public UserController(UserHandler handler) {
        this.handler = handler;
    }

    @Override
    public User create(User entity) {
        return handler.create(entity);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    public User read(@PathVariable("id") Long id) {
        return handler.read(id);
    }

    @Override
    public User update(User entity) {
        return handler.update(entity);
    }

    @Override
    public boolean delete(Long id) {
        return handler.delete(id);
    }

    @PostMapping(path = "/login", consumes = {MediaType.APPLICATION_JSON_VALUE})
    public User login(@RequestBody User entity) {
        return handler.login(entity);
    }

    @PostMapping(path = "register", consumes = {MediaType.APPLICATION_JSON_VALUE})
    public User register(@RequestBody User entity) {
        try {
            return handler.register(entity);
        } catch (Exception e) {
            return null;
        }
    }
}
