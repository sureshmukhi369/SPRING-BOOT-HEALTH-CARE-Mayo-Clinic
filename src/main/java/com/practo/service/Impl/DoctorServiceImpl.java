package com.practo.service.Impl;

import com.practo.entity.Doctor;
import com.practo.repository.DoctorRepository;
import com.practo.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorServiceImpl implements DoctorService {

    @Autowired
    private DoctorRepository doctorRepository;

    @Override
    public Doctor addDoctor(Doctor doctor) {
        Doctor save = doctorRepository.save(doctor);
        return save;
    }

    @Override
    public List<Doctor> getAllDoctors() {
        return doctorRepository.findAll();
    }

    @Override
    public List<Doctor> searchDoctors(String search){
        List<Doctor> doctors = doctorRepository.searchDoctors(search);
        return doctors;
    }

    // Other CRUD operations or additional business logic can be added here
}
