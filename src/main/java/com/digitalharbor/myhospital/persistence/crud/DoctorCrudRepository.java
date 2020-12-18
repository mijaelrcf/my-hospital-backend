package com.digitalharbor.myhospital.persistence.crud;

import com.digitalharbor.myhospital.persistence.entity.Doctor;
import org.springframework.data.repository.CrudRepository;

public interface DoctorCrudRepository extends CrudRepository<Doctor, Integer> {
}
