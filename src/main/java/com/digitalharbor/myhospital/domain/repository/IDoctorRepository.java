package com.digitalharbor.myhospital.domain.repository;

import com.digitalharbor.myhospital.domain.DoctorDomain;

import java.util.List;
import java.util.Optional;

public interface IDoctorRepository {
    List<DoctorDomain> getAll();
    Optional<DoctorDomain> get(int id);
    DoctorDomain save (DoctorDomain doctor);
    void delete (int id);
}
