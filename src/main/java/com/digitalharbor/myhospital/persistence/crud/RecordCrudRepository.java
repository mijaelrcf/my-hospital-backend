package com.digitalharbor.myhospital.persistence.crud;

import com.digitalharbor.myhospital.persistence.entity.Record;
import org.springframework.data.repository.CrudRepository;

public interface RecordCrudRepository extends CrudRepository<Record, Integer> {

}
