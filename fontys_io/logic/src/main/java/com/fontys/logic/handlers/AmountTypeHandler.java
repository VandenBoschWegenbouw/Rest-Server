package com.fontys.logic.handlers;

import com.fontys.dal.services.AmountTypeService;
import com.fontys.domain.interfaces.CRUD;
import com.fontys.domain.models.AmountType;
import com.fontys.logic.components.AmountTypeComponent;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AmountTypeHandler implements CRUD<AmountType, Long> {
    @Setter
    private AmountTypeService service;

    @Setter
    private AmountTypeComponent component;

    public AmountTypeHandler() {
    }

    @Autowired
    public AmountTypeHandler(AmountTypeService service, AmountTypeComponent component) {
        this.service = service;
        this.component = component;
    }


    @Override
    public AmountType create(AmountType entity) {
        return service.create(entity);
    }

    @Override
    public AmountType read(Long id) {
        return service.read(id);
    }

    @Override
    public Iterable<AmountType> readAll() {
        return service.readAll();
    }

    @Override
    public AmountType update(AmountType entity) {
        return service.update(entity);
    }

    @Override
    public boolean delete(Long id) {
        return service.delete(id);
    }
}
