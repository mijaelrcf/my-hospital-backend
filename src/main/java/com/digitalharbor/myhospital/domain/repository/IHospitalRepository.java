package com.digitalharbor.myhospital.domain.repository;

import com.digitalharbor.myhospital.domain.dto.HospitalDto;

import java.util.List;
import java.util.Optional;

public interface IHospitalRepository {
    List<HospitalDto> getAll();
    Optional<HospitalDto> get(int id);
    HospitalDto save (HospitalDto hospital);
    HospitalDto update (HospitalDto hospital);
    void delete (int id);
}
