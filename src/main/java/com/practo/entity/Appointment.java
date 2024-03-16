package com.practo.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;


@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "appointments")
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long patientId;
    private Long doctorId;
    private String appointmentTime;

}

//    @ManyToOne
//    @JoinColumn(name = "doctor_Id", referencedColumnName = "dId")
//    private Doctor doctor;
//

//
//    @Column(nullable = false)
//    private boolean morningSlotAvailable;
//
//    @Column(nullable = false)
//    private boolean afternoonSlotAvailable;
//
//    @Column(nullable = false)
//    private boolean eveningSlotAvailable;
//
//

