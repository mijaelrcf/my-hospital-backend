package com.digitalharbor.myhospital.domain.repository;

import com.digitalharbor.myhospital.domain.dto.DoctorDto;

import java.util.List;
import java.util.Optional;

public interface IDoctorRepository {
    List<DoctorDto> getAll();
    Optional<DoctorDto> get(int id);
    DoctorDto save (DoctorDto doctor);
    void delete (int id);
}
