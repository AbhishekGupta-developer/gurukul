package com.myorganisation.gurukul.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.myorganisation.gurukul.enums.VehicleType;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "vehicles")
public class Vehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private VehicleType type;

    private String registrationNumber;

    @OneToOne(mappedBy = "vehicle")
    @JsonIgnore
    private Student student;
}
