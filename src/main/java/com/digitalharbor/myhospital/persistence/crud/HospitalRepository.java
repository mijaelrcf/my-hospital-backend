package com.digitalharbor.myhospital.persistence.crud;

import com.digitalharbor.myhospital.persistence.entity.Hospital;

import java.util.List;

public class HospitalRepository {
    private HospitalCrudRepository hospitalCrudRepository;

    public List<Hospital> getAll() {
        return (List<Hospital>) hospitalCrudRepository.findAll();
    }
}
