package com.digitalharbor.myhospital.persistence.mapper;

import com.digitalharbor.myhospital.domain.dto.SpecialtyDto;
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
    SpecialtyDto toSpecialty(Specialty specialty);

    List<SpecialtyDto> toSpecialtys (List<Specialty> specialtyList);

    @InheritInverseConfiguration
    @Mapping(target = "createdDate", ignore = true)
    @Mapping(target = "updatedDate", ignore = true)
    @Mapping(target = "createdBy", ignore = true)
    @Mapping(target = "updatedBy", ignore = true)
    Specialty toSpecialty(SpecialtyDto specialty);
}
