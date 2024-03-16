package com.practo.service.Impl;


//import com.practo.config.TimeSlotManager;
import com.practo.entity.Appointment;
import com.practo.payload.BookingDto;
import com.practo.repository.AppointmentRepository;
import com.practo.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@Service
public class AppointmentServiceImpl implements AppointmentService {

    @Autowired
    private AppointmentRepository appointmentRepo;
//    @Autowired
//    private TimeSlotManager timeSlotManager;

//    public void bookAppointment(BookingDto bookingDto){
//
//       List<String> availableTimeSlots = timeSlotManager.getAvailableTimeSlots();
//
//        Appointment appointment = new Appointment();
//
//        for (String slots : availableTimeSlots) {
//            if (slots.equals(bookingDto.getAppointmentTime())) {
//                appointment.setAppointmentTime(bookingDto.getAppointmentTime());
//                availableTimeSlots.remove(slots);
//                timeSlotManager.setAvailableTimeSlots(availableTimeSlots);
//            }
//        }
//
////            appointment.setDoctorId(bookingDto.getDoctorId());
////            appointment.setPatientId(bookingDto.getPatientId());
////
////            // Scheduled the task to run every 24 hours
//            ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
//            executor.scheduleAtFixedRate(
//                    ()-> {
//                        // cod to execute every 24 hours
//                        System.out.print("Executing code every 24 hours.....");
//
//                        // Here u can place the code to remove elements from the list
//                        // For example , remove elements from the 'availableTimeSlots' list
//
//                        availableTimeSlots.add("10.15AM");
//                        availableTimeSlots.add("11.15AM");
//                        availableTimeSlots.add("12.15 PM");
//
//
//                    }, 0, 24, TimeUnit.HOURS
//            );
//
//
//            if (appointment.getAppointmentTime() != null) {
//                appointmentRepo.save(appointment);
//            } else {
//                System.out.print("Time slot is not available");
//            }
//        }

    @Override
    public void bookAnAppointment(BookingDto dto) {

        List<String> availableTimeSlots = new ArrayList<>();
        availableTimeSlots.add("10:15 AM");
        availableTimeSlots.add("11:15 AM");
        availableTimeSlots.add("12:15 PM");

        // Schedule the task to run every 24 hours
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
        executor.scheduleAtFixedRate(() -> {
            // Your task logic here
            System.out.println("Task executed every 24 hours");

            // Add or update the available time slots
            availableTimeSlots.clear();
            availableTimeSlots.add("10:15 AM");
            availableTimeSlots.add("11:15 AM");
            availableTimeSlots.add("12:15 PM");

        }, 0, 24, TimeUnit.HOURS);

        Appointment booking =new Appointment();

        for (String slots:availableTimeSlots) {
            if (slots.equals(dto.getAppointmentTime())){
                booking.setAppointmentTime(dto.getAppointmentTime());
                availableTimeSlots.remove(slots);
            }
        }

        booking.setDoctorId(dto.getDoctorId());
        booking.setPatientId(dto.getPatientId());

        if(booking.getAppointmentTime()!=null) {
            appointmentRepo.save(booking);
        }else{
            System.out.println("Time slot not avlaible");
        }
    }

}
