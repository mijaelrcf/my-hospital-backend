package com.digitalharbor.myhospital.persistence.crud;

import com.digitalharbor.myhospital.persistence.entity.Specialty;
import org.springframework.data.repository.CrudRepository;

public interface SpecialtyCrudRepository extends CrudRepository<Specialty, Integer> {
}
