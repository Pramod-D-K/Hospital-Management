package com.acciojob.first_api_learning.Entities;

import com.acciojob.first_api_learning.DoctorCardStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DoctorCard {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int cardId;

    private LocalDate issueDate;

    private LocalDate expiryDate;

    @Enumerated(value = EnumType.STRING)
    private DoctorCardStatus doctorCardStatus=DoctorCardStatus.INACTIVE;

    @JoinColumn
    @OneToOne
    private Doctor doctor;
}
