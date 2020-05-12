package com.fontys.dal.services;

import com.fontys.dal.repositories.UserRepository;
import com.fontys.domain.interfaces.CRUD;
import com.fontys.domain.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class UserService implements CRUD<User, Long> {

    @Autowired
    @Qualifier("UserRepository")
    private UserRepository repository;

    @Override
    public User create(User entity) {
        return repository.save(entity);
    }

    @Override
    public User read(Long id) {
        return repository.findById(id).get();
    }

    @Override
    public Iterable<User> readAll() {
        return repository.findAll();
    }

    @Override
    public User update(User entity) {
        return repository.save(entity);
    }

    @Override
    public boolean delete(Long id) {
        repository.deleteById(id);
        return true;
    }

    public User getUserByUserNameAndPassword(String username, String password) {
        return repository.getUserByUsernameAndPassword(username,password);
    }

    public Boolean findUsername(String username) {
        return repository.findUsername(username);
    }
}
