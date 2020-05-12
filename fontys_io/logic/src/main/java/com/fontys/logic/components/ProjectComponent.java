package com.fontys.logic.components;

import com.fontys.dal.services.ProjectService;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProjectComponent {
    @Setter
    private ProjectService service;

    public ProjectComponent() {
    }

    @Autowired
    public ProjectComponent(ProjectService service) {
        this.service = service;
    }
}