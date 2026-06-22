package com.myorganisation.gurukul.entity;

import com.myorganisation.gurukul.enums.Gender;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "students")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String course;
    private String phone;
    private String mail;

    @Enumerated(EnumType.STRING)
    private Gender gender;
}
