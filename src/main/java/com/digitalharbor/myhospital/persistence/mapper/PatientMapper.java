package com.digitalharbor.myhospital.persistence.mapper;

import com.digitalharbor.myhospital.domain.PatientDomain;
import com.digitalharbor.myhospital.persistence.entity.Hospital;
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
    PatientDomain toPatient(Patient patient);

    List<PatientDomain> toPatients (List<Patient> patientList);

    @InheritInverseConfiguration
    @Mapping(target = "createdDate", ignore = true)
    @Mapping(target = "updatedDate", ignore = true)
    @Mapping(target = "createdBy", ignore = true)
    @Mapping(target = "updatedBy", ignore = true)
    Patient toPatient(PatientDomain patient);
}
