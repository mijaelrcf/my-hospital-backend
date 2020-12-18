package com.digitalharbor.myhospital.domain.repository;

import com.digitalharbor.myhospital.domain.HospitalDomain;

import java.util.List;
import java.util.Optional;

public interface IHospitalRepository {
    List<HospitalDomain> getAll();
    Optional<HospitalDomain> get(int id);
    HospitalDomain save (HospitalDomain hospital);
    void delete (int id);
}
