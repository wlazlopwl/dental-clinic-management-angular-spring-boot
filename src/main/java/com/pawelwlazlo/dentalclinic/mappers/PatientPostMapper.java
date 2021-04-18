package com.pawelwlazlo.dentalclinic.mappers;

import com.pawelwlazlo.dentalclinic.dto.PatientDto;
import com.pawelwlazlo.dentalclinic.dto.PatientPostDto;
import com.pawelwlazlo.dentalclinic.model.Patient;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface PatientPostMapper {

    PatientPostMapper INSTANCE = Mappers.getMapper(PatientPostMapper.class);


    PatientPostDto toDTO(Patient patient);

    Patient fromDTO(PatientPostDto patientPostDto );

}
