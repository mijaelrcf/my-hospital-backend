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
    private ISpecialtyRepository iSpecialtyRepository;

    public List<SpecialtyDto> getAll() {
        return iSpecialtyRepository.getAll();
    }

    public Optional<SpecialtyDto> get(int id) {
        return iSpecialtyRepository.get(id);
    }

    public SpecialtyDto save(SpecialtyDto specialty) {
        return iSpecialtyRepository.save(specialty);
    }

    public SpecialtyDto update(SpecialtyDto specialty) {
        return iSpecialtyRepository.update(specialty);
    }

    public boolean delete (int id) {
        if (get(id).isPresent()) {
            iSpecialtyRepository.delete(id);
            return true;
        } else {
            return false;
        }
    }
}
