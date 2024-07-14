package com.healthcare.ehrservice.controller;

import com.healthcare.ehrservice.interoperability.InteroperabilityService;
import com.healthcare.ehrservice.model.PatientRecord;
import com.healthcare.ehrservice.service.PatientRecordService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@RestController
@RequestMapping("/api/patient")
public class PatientRecordController {
    private final PatientRecordService patientRecordService;
    private final InteroperabilityService interoperabilityService;

    public PatientRecordController(PatientRecordService patientRecordService,InteroperabilityService interoperabilityService) {
        this.patientRecordService = patientRecordService;
        this.interoperabilityService=interoperabilityService;
    }

    @GetMapping("/test")
    public ResponseEntity<?> apiTest() {
        System.out.println("ygjhhjh");
        return ResponseEntity.ok("Application is working");
    }

    @PostMapping("/createPatientRecord")
    public PatientRecord createPatientRecord(@RequestBody PatientRecord record) {
        System.out.println("create "+record.toString());
        return patientRecordService.createPatientRecord(record);
    }

    @GetMapping("/getPatientRecord")
    public ResponseEntity<PatientRecord> getPatientRecord(@RequestParam Long patientId) {
        return ResponseEntity.ok(patientRecordService.getPatientRecord(patientId));
    }

    @PutMapping("/updatePatientRecord")
    public ResponseEntity<PatientRecord> updatePatientRecord(@RequestBody PatientRecord record) {
        return ResponseEntity.ok(patientRecordService.updatePatientRecord(record));
    }

    @GetMapping("/all")
    public ResponseEntity<List<PatientRecord>> getAllPatientRecords() {
        return ResponseEntity.ok(patientRecordService.getAllPatientRecords());
    }

    @DeleteMapping("/deletePatientRecord/{id}")
    public void deletePatientRecord(@PathVariable Long id) {
        patientRecordService.deletePatientRecord(id);
    }

    @GetMapping("/exportFHIR")
    public String exportFHIR(@RequestParam Long patientId) {
        PatientRecord patientRecord = patientRecordService.getPatientRecord(patientId);
        return interoperabilityService.convertToFHIRFormat(patientRecord);
    }

    @GetMapping("/exportHL7")
    public String exportHL7(@RequestParam Long patientId) {
        PatientRecord patientRecord = patientRecordService.getPatientRecord(patientId);
        return interoperabilityService.convertToHL7Format(patientRecord);
    }
}