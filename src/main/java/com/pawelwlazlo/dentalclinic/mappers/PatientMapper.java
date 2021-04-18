package com.pawelwlazlo.dentalclinic.mappers;

import com.pawelwlazlo.dentalclinic.dto.PatientDto;
import com.pawelwlazlo.dentalclinic.model.Patient;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {VisitMapper.class})
public interface PatientMapper {

    PatientDto toDTO(Patient patient);

    Patient fromDTO(PatientDto patientDto);

}
