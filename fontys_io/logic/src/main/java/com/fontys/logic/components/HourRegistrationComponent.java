package com.fontys.logic.components;

import com.fontys.dal.services.HourRegistrationService;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class HourRegistrationComponent {
    @Setter
    private HourRegistrationService service;

    public HourRegistrationComponent() {
    }

    @Autowired
    public HourRegistrationComponent(HourRegistrationService service) {
        this.service = service;
    }
}
