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
        return service.getUserByUserNameAndPassword(entity.getUsername(),DigestUtils.sha256Hex(entity.getPassword()));
    }

    public User register(User entity) {

        if (!service.findUsername(entity.getUsername())) {

            User tmpEntity = new User(entity.getUsername(), DigestUtils.sha256Hex(entity.getPassword()), entity.getIsAdmin());

            return service.create(tmpEntity);
        } else {
            throw new IllegalArgumentException();
        }
    }

}
