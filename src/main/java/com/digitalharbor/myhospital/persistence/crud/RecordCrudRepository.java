package com.digitalharbor.myhospital.persistence.crud;

import com.digitalharbor.myhospital.persistence.entity.Record;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface RecordCrudRepository extends CrudRepository<Record, Integer> {
    List<Record> findByPatientId(int patientId);
}
