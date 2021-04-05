package com.pawelwlazlo.dentalclinic.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.pawelwlazlo.dentalclinic.types.GenderType;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@NoArgsConstructor
public class Doctor implements Serializable {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false)
    private Long id;
    private String firstName;
    private String lastName;
    private String PESEL;
    private String phone;
    private String otherPhone;
    private String email;
    private int age;
    private String doctorCode;
    @Enumerated(EnumType.STRING)
    private GenderType genderType;

    @JsonBackReference
    @OneToOne(mappedBy = "doctor")
    private Visit visit;


}
