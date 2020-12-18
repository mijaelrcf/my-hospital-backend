package com.digitalharbor.myhospital.persistence.crud;

import com.digitalharbor.myhospital.persistence.entity.Patient;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface PatientCrudRepository extends CrudRepository<Patient, Integer> {
    Optional<List<Patient>> findByName(String name);
}
