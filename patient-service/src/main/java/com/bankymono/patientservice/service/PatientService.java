package com.bankymono.patientservice.service;

import com.bankymono.patientservice.dto.PatientResponseDTO;
import com.bankymono.patientservice.model.Patient;
import com.bankymono.patientservice.model.PatientMapper;
import com.bankymono.patientservice.repository.PatientRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientService {
    private PatientRepository patientRepository;

    public PatientService(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    public List<PatientResponseDTO> getPatients(){
        List<Patient> patients = patientRepository.findAll();

        return patients.stream().map(
                PatientMapper::toDTO
        ).toList();
    }
}
