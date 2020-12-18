package com.digitalharbor.myhospital.persistence.mapper;

import com.digitalharbor.myhospital.domain.DoctorDomain;
import com.digitalharbor.myhospital.persistence.entity.Doctor;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface DoctorMapper {
    @Mappings({
            //@Mapping(source = "name", target = "name")
    })
    DoctorDomain toDoctor(Doctor doctor);

    List<DoctorDomain> toDoctors (List<Doctor> doctorList);

    @InheritInverseConfiguration
    @Mapping(target = "createdDate", ignore = true)
    @Mapping(target = "updatedDate", ignore = true)
    @Mapping(target = "createdBy", ignore = true)
    @Mapping(target = "updatedBy", ignore = true)
    Doctor toDoctor(DoctorDomain doctor);
}
