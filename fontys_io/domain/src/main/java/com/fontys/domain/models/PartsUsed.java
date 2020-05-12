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
@Entity(name = "partsused")
public class PartsUsed {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonSerialize
    private Long idPartsUsed;
    private int amount;
    private String specification;
    private LocalDateTime dateUsed = LocalDateTime.now();

    @OneToOne
    @JoinColumn(name = "part_type_id", referencedColumnName = "idPartType")
    private PartType partType;

    @OneToOne
    @JoinColumn(name = "amount_type_id", referencedColumnName = "idAmountType")
    private AmountType amountType;

    @ManyToOne
    @JoinColumn(name = "project_id", referencedColumnName = "idProject")
    private Project project;

    @ManyToOne
    @JoinColumn(name = "user_id",referencedColumnName = "idUser")
    private User user;
}
