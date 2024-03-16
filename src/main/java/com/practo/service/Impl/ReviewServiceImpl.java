package com.practo.service.Impl;

import com.practo.entity.Doctor;
import com.practo.entity.Patient;
import com.practo.entity.Review;
import com.practo.repository.DoctorRepository;
import com.practo.repository.PatientRepository;
import com.practo.repository.ReviewRepository;
import com.practo.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewServiceImpl implements ReviewService {

    @Autowired
    private DoctorRepository doctorRepo;
    @Autowired
    private PatientRepository patientRepo;
    @Autowired
    private ReviewRepository reviewRepo;


    @Override
    public Review createReview(Review review){
        Doctor doctor = doctorRepo.findById(review.getDoctorId()).get();
        Patient patient = patientRepo.findById(review.getPatientId()).get();

        Review savedReview=null;
        if (doctor!=null || patient!=null){
             savedReview = reviewRepo.save(review);   //  add condition rating saved if should not be greater than 5
        }
        return savedReview;
    }

    @Override
    public List<Review> getReviewByDoctorId(long doctorId) {
        //  check doctorId is present or not
        List<Review> reviews = reviewRepo.findByDoctorId(doctorId);
        return reviews;
    }

}
