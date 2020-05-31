package com.fontys.logic.components;

import com.fontys.dal.services.UserService;
import com.fontys.domain.models.User;
import lombok.Setter;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserComponent {


    @Setter
    private UserService service;

    public UserComponent() {
    }

    @Autowired
    public UserComponent(UserService service) {
        this.service = service;
    }

    public User login(User entity) {
        return service.getUserByUserNameAndPassword(entity.getUsername(),entity.getPassword());
    }

    public User register(User entity) throws Exception {

        try {
            boolean result = service.findUsername(entity.getUsername());
            //Gives NullPointerException when no username is found
            throw new Exception("Username taken");
        } catch (NullPointerException e) {
            User tmpEntity = new User(entity.getUsername(), entity.getPassword(), entity.getIsAdmin());

            return service.create(tmpEntity);
        }
    }

}
