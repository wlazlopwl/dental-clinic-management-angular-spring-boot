package com.pawelwlazlo.dentalclinic.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.pawelwlazlo.dentalclinic.types.GenderType;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@Table(name = "patient")
public class Patient implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false)
    private Long id;
    private String firstName;
    private String secondName;
    private String lastName;
    private String PESEL;
    private String phone;
    private String otherPhone;
    private String email;
    private int age;
    private boolean isChild;
    private Date dateOfBirth;
    @Enumerated(EnumType.STRING)
    private GenderType gender;
    @Column(nullable = false, updatable = false)
    private String patientCode;
    @JsonManagedReference
    @JsonIgnore
    @OneToMany(mappedBy = "patient", fetch = FetchType.EAGER)
    private List<Visit> visits;
}
