package com.digitalharbor.myhospital.domain.repository;

import com.digitalharbor.myhospital.domain.dto.PatientDto;

import java.util.List;
import java.util.Optional;

public interface IPatientRepository {
    List<PatientDto> getAll();
    Optional<PatientDto> get(int id);
    PatientDto save (PatientDto patient);
    void delete (int id);
}
