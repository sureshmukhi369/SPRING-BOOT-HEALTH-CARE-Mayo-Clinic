package com.practo.service.Impl;

import com.practo.entity.Patient;
import com.practo.repository.PatientRepository;
import com.practo.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientServiceImpl implements PatientService {

    @Autowired
    private PatientRepository patientRepo;

    @Override
    public List<Patient> getAllPatients() {
        return patientRepo.findAll();
    }

    @Override
    public Patient createPatient(Patient patient) {
        return patientRepo.save(patient);
    }
}
