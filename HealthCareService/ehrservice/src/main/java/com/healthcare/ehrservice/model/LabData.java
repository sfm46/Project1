package com.healthcare.ehrservice.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table
@Getter
@Setter
public class LabData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long labDataId;
    private String testName;
    private String result;

    @ManyToOne
    @JoinColumn(name = "patient_record_id")
    private PatientRecord patientRecord;

    // Getters and Setters
}