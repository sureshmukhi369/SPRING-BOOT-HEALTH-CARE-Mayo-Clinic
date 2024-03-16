package com.practo.service;

import com.practo.entity.Patient;

import java.util.List;

public interface PatientService {

    List<Patient> getAllPatients();
    Patient createPatient(Patient patient);
}
