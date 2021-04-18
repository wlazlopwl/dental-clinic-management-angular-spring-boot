package com.pawelwlazlo.dentalclinic.mappers;

import com.pawelwlazlo.dentalclinic.dto.VisitDto;
import com.pawelwlazlo.dentalclinic.model.Visit;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface VisitMapper {

    @Mapping(target = "patientId", source = "visit.patient.id")
    VisitDto toDTO(Visit visit);

    Visit fromDTO(VisitDto visitDto);

}
