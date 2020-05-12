package com.fontys.domain.models;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "hourregistration")
public class HourRegistration {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonSerialize
    private Long idHourRegistration;
    private int hours;
    private LocalDateTime date;
    private String description;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "idUser")
    private User user;

    @ManyToOne
    @JoinColumn(name = "project_id", referencedColumnName = "idProject")
    private Project project;
}
