package com.fontys.logic.components;

import com.fontys.dal.services.HourRegistrationService;
import com.fontys.domain.models.HourRegistration;
import com.fontys.domain.models.User;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

@Component
public class HourRegistrationComponent {
    @Setter
    private HourRegistrationService service;

    public HourRegistrationComponent() {
    }

    public HourRegistration create(HourRegistration entity) throws Exception {

        User user = entity.getUser();

        Date date = Date.valueOf(entity.getDate().toLocalDate());

        List<HourRegistration> todaysRegistrations = (List<HourRegistration>) service.readByDateAndUserId(date, user.getIdUser());

        int totalTime = 0;

        for (HourRegistration hr : todaysRegistrations) {
            totalTime += hr.getHours();
        }

        if (totalTime + entity.getHours() > 10)
            throw new Exception("Worked too much");

        return service.create(entity);
    }

    @Autowired
    public HourRegistrationComponent(HourRegistrationService service) {
        this.service = service;
    }
}
