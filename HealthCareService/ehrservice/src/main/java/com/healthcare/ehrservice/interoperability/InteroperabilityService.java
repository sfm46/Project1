package com.healthcare.ehrservice.interoperability;

import com.healthcare.ehrservice.model.PatientRecord;
import org.springframework.stereotype.Service;

@Service
public class InteroperabilityService {

    // Method to handle FHIR data exchange
    public String convertToFHIRFormat(PatientRecord patientData) {
       return Hl7MessageBuilder.buildHl7Message(patientData);
    }

    // Method to handle HL7 data exchange
    public String convertToHL7Format(Object patientData) {
        // Implement HL7 conversion logic
        return "HL7 formatted data";
    }
}