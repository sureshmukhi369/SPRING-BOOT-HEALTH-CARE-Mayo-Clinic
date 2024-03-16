package com.practo.repository;

import com.practo.entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface DoctorRepository extends JpaRepository<Doctor, Long> {
    // You can add custom query methods if needed

//    @Query("Select d from doctors d where d.doctorName LIKE %:search% OR d.specializations LIKE %:search%")
//    List<Doctor> searchByNameOrSpecialization(@Param("search") String search);

    @Query("SELECT d FROM Doctor d WHERE LOWER(d.doctorName) LIKE LOWER(CONCAT('%', :search, '%')) OR LOWER(d.specializations) LIKE LOWER(CONCAT('%', :search, '%'))")
    List<Doctor> searchDoctors(String search);
}

