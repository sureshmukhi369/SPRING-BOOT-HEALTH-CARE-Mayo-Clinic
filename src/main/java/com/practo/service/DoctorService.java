package com.practo.service;

import com.practo.entity.Doctor;

import java.util.List;

public interface DoctorService {

    public Doctor addDoctor(Doctor doctor);
    public List<Doctor> getAllDoctors();
    public List<Doctor> searchDoctors(String search);
}
