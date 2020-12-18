package com.digitalharbor.myhospital.domain.repository;

import com.digitalharbor.myhospital.domain.dto.RecordDto;

import java.util.List;
import java.util.Optional;

public interface IRecordRepository {
    List<RecordDto> getAll();
    Optional<RecordDto> get(int id);
    RecordDto save (RecordDto record);
    void delete (int id);
}
