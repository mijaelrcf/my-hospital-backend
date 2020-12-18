package com.digitalharbor.myhospital.domain.repository;

import com.digitalharbor.myhospital.domain.PatientDomain;

import java.util.List;
import java.util.Optional;

public interface IPatientRepository {
    List<PatientDomain> getAll();
    Optional<PatientDomain> get(int id);
    PatientDomain save (PatientDomain patient);
    void delete (int id);
}
