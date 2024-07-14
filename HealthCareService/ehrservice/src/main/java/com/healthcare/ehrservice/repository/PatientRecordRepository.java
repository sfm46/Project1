package com.healthcare.ehrservice.repository;

import com.healthcare.ehrservice.model.PatientRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientRecordRepository extends JpaRepository<PatientRecord, Long> {
    PatientRecord findByPatientId(Long patientId);
}