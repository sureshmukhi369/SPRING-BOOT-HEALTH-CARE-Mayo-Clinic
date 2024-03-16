package com.practo.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "doctors")
public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long dId;

    private  String doctorName;
    private  String qualification;
    private  String specializations;
    private  String experiance;
    private  String description;

}
