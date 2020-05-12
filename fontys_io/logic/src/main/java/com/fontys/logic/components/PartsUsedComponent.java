package com.fontys.logic.components;

import com.fontys.dal.services.PartsUsedService;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PartsUsedComponent {
    @Setter
    private PartsUsedService service;

    public PartsUsedComponent() {
    }

    @Autowired
    public PartsUsedComponent(PartsUsedService service) {
        this.service = service;
    }
}
