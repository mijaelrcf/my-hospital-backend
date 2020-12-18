package com.digitalharbor.myhospital.domain.repository;

import com.digitalharbor.myhospital.domain.SpecialtyDomain;

import java.util.List;
import java.util.Optional;

public interface ISpecialtyRepository {
    List<SpecialtyDomain> getAll();
    Optional<SpecialtyDomain> get(int id);
    SpecialtyDomain save (SpecialtyDomain record);
    void delete (int id);
}
