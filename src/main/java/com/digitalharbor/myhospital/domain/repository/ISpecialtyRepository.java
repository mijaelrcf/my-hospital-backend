package com.digitalharbor.myhospital.domain.repository;

import com.digitalharbor.myhospital.domain.dto.SpecialtyDto;

import java.util.List;
import java.util.Optional;

public interface ISpecialtyRepository {
    List<SpecialtyDto> getAll();
    Optional<SpecialtyDto> get(int id);
    SpecialtyDto save (SpecialtyDto record);
    void delete (int id);
}
