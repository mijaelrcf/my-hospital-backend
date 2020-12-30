package com.digitalharbor.myhospital.persistence.mapper;

import com.digitalharbor.myhospital.domain.dto.RecordDto;
import com.digitalharbor.myhospital.persistence.entity.Record;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring", uses = {PatientMapper.class})
public interface RecordMapper {
    @Mappings({
            @Mapping(source = "description", target = "description"),
            @Mapping(source = "recordDate", target = "recordDate")
    })
    RecordDto toRecord(Record record);
    List<RecordDto> toRecords (List<Record> records);

    @InheritInverseConfiguration
    @Mapping(target = "createdDate", ignore = true)
    @Mapping(target = "updatedDate", ignore = true)
    @Mapping(target = "createdBy", ignore = true)
    @Mapping(target = "updatedBy", ignore = true)
    @Mapping(target = "doctor", ignore = true)
    Record toRecord(RecordDto record);
}
