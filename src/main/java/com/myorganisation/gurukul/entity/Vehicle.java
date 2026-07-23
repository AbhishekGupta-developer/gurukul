package com.myorganisation.gurukul.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.myorganisation.gurukul.enums.VehicleType;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "vehicles")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Vehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private VehicleType type;

    private String registrationNumber;

    @ManyToOne(fetch = FetchType.LAZY)
    private Student student;
}
