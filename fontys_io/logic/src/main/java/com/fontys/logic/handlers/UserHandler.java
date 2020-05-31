package com.fontys.logic.handlers;

import com.fontys.dal.services.UserService;
import com.fontys.domain.interfaces.CRUD;
import com.fontys.domain.models.User;
import com.fontys.logic.components.UserComponent;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserHandler implements CRUD<User, Long> {

    @Setter
    private UserService service;

    @Setter
    private UserComponent component;

    public UserHandler() {
    }

    @Autowired
    public UserHandler(UserService service, UserComponent component) {
        this.service = service;
        this.component = component;
    }


    @Override
    public User create(User entity) {
        return service.create(entity);
    }

    @Override
    public User read(Long id) {
        return service.read(id);
    }

    @Override
    public Iterable<User> readAll() {
        return service.readAll();
    }

    @Override
    public User update(User entity) {
        return service.update(entity);
    }

    @Override
    public boolean delete(Long id) {
        return service.delete(id);
    }

    public User login(User entity) {
        return component.login(entity);
    }

    public User register(User entity) throws Exception {
        return component.register(entity);
    }
}
