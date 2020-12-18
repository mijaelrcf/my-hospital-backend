package com.digitalharbor.myhospital.persistence.mapper;

import com.digitalharbor.myhospital.domain.dto.PatientDto;
import com.digitalharbor.myhospital.persistence.entity.Patient;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PatientMapper {
    @Mappings({
            @Mapping(source = "name", target = "name")
    })
    PatientDto toPatient(Patient patient);

    List<PatientDto> toPatients (List<Patient> patientList);

    @InheritInverseConfiguration
    @Mapping(target = "createdDate", ignore = true)
    @Mapping(target = "updatedDate", ignore = true)
    @Mapping(target = "createdBy", ignore = true)
    @Mapping(target = "updatedBy", ignore = true)
    Patient toPatient(PatientDto patient);
}
