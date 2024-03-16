package com.practo.controller;

import com.practo.entity.Doctor;
import com.practo.entity.Review;
import com.practo.payload.DoctorDto;
import com.practo.repository.DoctorRepository;
import com.practo.service.Impl.ReviewServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reviews")
public class ReviewController {

    @Autowired
    private ReviewServiceImpl reviewService;

    @Autowired
    private DoctorRepository doctorRepository;


    @PostMapping("/saveReview")
    public ResponseEntity<Review> createReview(@RequestBody Review review){

        Review savedReview = reviewService.createReview(review);
        return new ResponseEntity<>(savedReview, HttpStatus.CREATED);
    }

    @GetMapping("/{doctorId}")
    public ResponseEntity<DoctorDto> getReviewsByDoctorId(@PathVariable long doctorId){

        Doctor doctor = doctorRepository.findById(doctorId).get();
        List<Review> reviewsByDoctorId = reviewService.getReviewByDoctorId(doctorId);

        double totalRating = 0;
        int totalReviews = 0;
        for (Review review : reviewsByDoctorId){
            totalRating += review.getRating();
            totalReviews++ ;
        }
        // Calculate the average rating percentage
        double averageRating = totalRating / reviewsByDoctorId.size();
        double ratingPercentage = (averageRating / 5.0) * 100;

        DoctorDto dto = new DoctorDto();
        dto.setDoctor(doctor);
        dto.setReviews(reviewsByDoctorId);
        dto.setRatingPercentage(ratingPercentage);

        return new ResponseEntity<>(dto, HttpStatus.CREATED);
    }


}
