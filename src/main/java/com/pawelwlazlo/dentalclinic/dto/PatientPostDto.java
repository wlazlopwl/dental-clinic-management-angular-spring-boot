package com.pawelwlazlo.dentalclinic.dto;

import com.pawelwlazlo.dentalclinic.types.GenderType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PatientPostDto {

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
    private GenderType gender;

}