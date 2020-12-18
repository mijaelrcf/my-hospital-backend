package com.digitalharbor.myhospital.persistence.crud;

import com.digitalharbor.myhospital.persistence.entity.Hospital;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface HospitalCrudRepository extends CrudRepository<Hospital, Integer> {
    Optional<List<Hospital>> findByName(String name);
}
