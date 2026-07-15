package com.myorganisation.gurukul.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "accounts")
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double total = 0D;
    private Double balance = 0D;

    @OneToOne(mappedBy = "account")
    private Student student;
}
