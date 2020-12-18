package com.digitalharbor.myhospital.domain.repository;

import com.digitalharbor.myhospital.domain.RecordDomain;

import java.util.List;
import java.util.Optional;

public interface IRecordRepository {
    List<RecordDomain> getAll();
    Optional<RecordDomain> get(int id);
    RecordDomain save (RecordDomain record);
    void delete (int id);
}
