package com.digitalharbor.myhospital.persistence.mapper;

import com.digitalharbor.myhospital.domain.HospitalDomain;
import com.digitalharbor.myhospital.persistence.entity.Hospital;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring", uses = {PatientMapper.class, DoctorMapper.class})
public interface HospitalMapper {
    @Mappings({
            @Mapping(source = "id", target = "id"),
            @Mapping(source = "name", target = "name"),
            @Mapping(source = "patients", target = "patients")
    })
    HospitalDomain toHospital(Hospital hospital);

    List<HospitalDomain> toHospitals (List<Hospital> hospitalList);

    @InheritInverseConfiguration
    @Mapping(target = "createdDate", ignore = true)
    @Mapping(target = "updatedDate", ignore = true)
    @Mapping(target = "createdBy", ignore = true)
    @Mapping(target = "updatedBy", ignore = true)
    Hospital toHospital(HospitalDomain hospital);
}
