package com.fontys.logic.components;

import com.fontys.dal.services.HourRegistrationService;
import com.fontys.dal.services.ProjectService;
import com.fontys.domain.models.HourRegistration;
import com.fontys.domain.models.Project;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Date;
import java.time.LocalDate;

@Component
public class ProjectComponent {
    @Setter
    private ProjectService service;

    @Setter
    private HourRegistrationService hourRegistrationService;

    public ProjectComponent() {
    }

    @Autowired
    public ProjectComponent(ProjectService service, HourRegistrationService hourRegistrationService) {
        this.service = service;
        this.hourRegistrationService = hourRegistrationService;
    }

    public Iterable<HourRegistration> readAndExport(Long id) {
        Project p = service.read(id);

        p.setIsFinished(true);
        p.setFinishDate(Date.valueOf(LocalDate.now()));

        service.update(p);

        return hourRegistrationService.readByProjectId(id);
    }
}