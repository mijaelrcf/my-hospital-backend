package com.digitalharbor.myhospital.persistence.mapper;

import com.digitalharbor.myhospital.domain.SpecialtyDomain;
import com.digitalharbor.myhospital.persistence.entity.Specialty;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface SpecialtyMapper {
    @Mappings({
            //@Mapping(source = "name", target = "name")
    })
    SpecialtyDomain toSpecialty(Specialty specialty);

    List<SpecialtyDomain> toSpecialtys (List<Specialty> specialtyList);

    @InheritInverseConfiguration
    @Mapping(target = "createdDate", ignore = true)
    @Mapping(target = "updatedDate", ignore = true)
    @Mapping(target = "createdBy", ignore = true)
    @Mapping(target = "updatedBy", ignore = true)
    Specialty toSpecialty(SpecialtyDomain specialty);
}
