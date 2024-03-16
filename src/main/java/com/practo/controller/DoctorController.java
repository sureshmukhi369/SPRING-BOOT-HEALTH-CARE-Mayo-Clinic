package com.practo.controller;

import com.practo.entity.Doctor;
import com.practo.service.Impl.DoctorServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/doctors")
public class DoctorController {

    @Autowired
    private DoctorServiceImpl doctorService;

    //--- http://localhost:8080/api/doctors/addDoctor
    @PostMapping("/addDoctor")
    public ResponseEntity<Doctor> addDoctor(@RequestBody Doctor doctor) {
        //System.out.println(doctor.getExperiance());
        Doctor addDoctor = doctorService.addDoctor(doctor);
        return new ResponseEntity<>(addDoctor, HttpStatus.CREATED);
    }

    //---  http://localhost:8080/api/doctors/searchDoctor?search=Cardiology
    @GetMapping("/searchDoctor")
    public ResponseEntity<List<Doctor>> searchDoctors(@RequestParam String search){
        List<Doctor> doctors = doctorService.searchDoctors(search);
        return new ResponseEntity<>(doctors, HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Doctor>> getAllDoctors() {
        List<Doctor> doctors = doctorService.getAllDoctors();
        return new ResponseEntity<>(doctors, HttpStatus.OK);
    }
    // Other CRUD operations or additional endpoints can be added here
}
