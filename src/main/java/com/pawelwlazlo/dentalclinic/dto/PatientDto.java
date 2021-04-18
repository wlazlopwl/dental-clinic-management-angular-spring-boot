package com.pawelwlazlo.dentalclinic.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.pawelwlazlo.dentalclinic.model.Visit;
import com.pawelwlazlo.dentalclinic.types.GenderType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PatientDto {

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
    private List<VisitDto> visits;
}