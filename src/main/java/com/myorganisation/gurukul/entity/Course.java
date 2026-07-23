package com.myorganisation.gurukul.entity;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "courses")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String code;

    private String name;
    private String description;
    private Double duration;
    private Double fee;

    @ManyToMany(mappedBy = "courses")
    private Set<Student> students = new HashSet<>();
}
