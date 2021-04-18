package com.pawelwlazlo.dentalclinic.dto;

import com.pawelwlazlo.dentalclinic.model.Doctor;
import com.pawelwlazlo.dentalclinic.model.Patient;
import com.pawelwlazlo.dentalclinic.model.Room;
import com.pawelwlazlo.dentalclinic.types.VisitStatusType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class VisitDto {

    private Long id;

    private String visitDate;

    private String createDate;

    private String updateDate;

    private VisitStatusType visitStatusType;

    private String patientId;


    private Room room;
    private Doctor doctor;


}
