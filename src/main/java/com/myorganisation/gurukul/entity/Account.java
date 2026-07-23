package com.myorganisation.gurukul.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "accounts")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double total = 0D;
    private Double balance = 0D;

    @OneToOne(fetch = FetchType.LAZY)
    private Student student;
}
