package com.myorganisation.gurukul.entity;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "classrooms")
public class Classroom {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long roomNumber;
    private Long floorNumber;
    private Long capacity;

    @OneToMany(mappedBy = "classroom")
    private Set<Student> students = new HashSet<>();
}
