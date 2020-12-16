package com.digitalharbor.myhospital.persistence.crud;

import com.digitalharbor.myhospital.persistence.entity.Hospital;
import org.springframework.data.repository.CrudRepository;

public interface HospitalCrudRepository extends CrudRepository<Hospital, Integer> {
}
