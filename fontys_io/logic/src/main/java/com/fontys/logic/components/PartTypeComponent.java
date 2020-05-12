package com.fontys.logic.components;

import com.fontys.dal.services.PartTypeService;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PartTypeComponent {
    @Setter
    private PartTypeService service;

    public PartTypeComponent() {
    }

    @Autowired
    public PartTypeComponent(PartTypeService service) {
        this.service = service;
    }
}
