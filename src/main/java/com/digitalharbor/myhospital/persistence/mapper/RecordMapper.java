package com.digitalharbor.myhospital.persistence.mapper;

import com.digitalharbor.myhospital.domain.RecordDomain;
import com.digitalharbor.myhospital.persistence.entity.Record;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface RecordMapper {
    @Mappings({
            //@Mapping(source = "name", target = "name")
    })
    RecordDomain toRecord(Record record);

    List<RecordDomain> toRecords (List<Record> recordList);

    @InheritInverseConfiguration
    @Mapping(target = "createdDate", ignore = true)
    @Mapping(target = "updatedDate", ignore = true)
    @Mapping(target = "createdBy", ignore = true)
    @Mapping(target = "updatedBy", ignore = true)
    Record toRecord(RecordDomain record);
}
