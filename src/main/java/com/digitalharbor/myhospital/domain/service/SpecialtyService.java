package com.digitalharbor.myhospital.domain.service;

import com.digitalharbor.myhospital.domain.dto.SpecialtyDto;
import com.digitalharbor.myhospital.domain.repository.ISpecialtyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SpecialtyService {
    @Autowired
    private ISpecialtyRepository specialtyRepository;

    public List<SpecialtyDto> getAll() {
        return specialtyRepository.getAll();
    }

    public Optional<SpecialtyDto> get(int id) {
        return specialtyRepository.get(id);
    }

    public SpecialtyDto save(SpecialtyDto specialty) {
        return specialtyRepository.save(specialty);
    }

    public boolean delete (int id) {
        if (get(id).isPresent()) {
            specialtyRepository.delete(id);
            return true;
        } else {
            return false;
        }
    }
}
