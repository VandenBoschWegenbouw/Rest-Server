package com.fontys.logic.components;

import com.fontys.dal.services.AmountTypeService;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AmountTypeComponent {
    @Setter
    private AmountTypeService service;

    public AmountTypeComponent() {
    }

    @Autowired
    public AmountTypeComponent(AmountTypeService service) {
        this.service = service;
    }
}
