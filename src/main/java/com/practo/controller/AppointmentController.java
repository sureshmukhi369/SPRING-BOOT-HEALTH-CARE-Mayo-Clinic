package com.practo.controller;


import com.practo.payload.BookingDto;
import com.practo.service.Impl.AppointmentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/appointments")
public class AppointmentController {
    @Autowired
    private AppointmentServiceImpl appointmentService;

    @PostMapping
    public ResponseEntity<String> bookAppointment(@RequestBody BookingDto bookingDto){
        appointmentService.bookAnAppointment(bookingDto);
       return new ResponseEntity<>("Booking is confirmed", HttpStatus.CREATED);

    }
}
