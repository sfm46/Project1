package com.healthcare.ehrservice.service;

import com.healthcare.ehrservice.model.PatientRecord;
import com.healthcare.ehrservice.repository.PatientRecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientRecordService {

    @Autowired
    private PatientRecordRepository repository;

    public PatientRecord getPatientRecord(Long patientId) {
        return repository.findByPatientId(patientId);
    }

    public PatientRecord updatePatientRecord(PatientRecord record) {
        return repository.save(record);
    }

    public List<PatientRecord> getAllPatientRecords() {
        return repository.findAll();
    }

    public PatientRecord createPatientRecord(PatientRecord record) {
        return repository.save(record);
    }

    public void deletePatientRecord(Long id) {
        repository.deleteById(id);
    }

}