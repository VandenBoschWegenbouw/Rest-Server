package com.fontys.logic.handlers;

import com.fontys.dal.services.PartTypeService;
import com.fontys.domain.interfaces.CRUD;
import com.fontys.domain.models.PartType;
import com.fontys.logic.components.PartTypeComponent;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PartTypeHandler implements CRUD<PartType, Long> {
    @Setter
    private PartTypeService service;

    @Setter
    private PartTypeComponent component;

    public PartTypeHandler() {
    }

    @Autowired
    public PartTypeHandler(PartTypeService service, PartTypeComponent component) {
        this.service = service;
        this.component = component;
    }


    @Override
    public PartType create(PartType entity) {
        return service.create(entity);
    }

    @Override
    public PartType read(Long id) {
        return service.read(id);
    }

    @Override
    public Iterable<PartType> readAll() {
        return service.readAll();
    }

    @Override
    public PartType update(PartType entity) {
        return service.update(entity);
    }

    @Override
    public boolean delete(Long id) {
        return service.delete(id);
    }
}
