package com.digitalharbor.myhospital.domain.service;

import com.digitalharbor.myhospital.domain.dto.HospitalDto;
import com.digitalharbor.myhospital.domain.repository.IHospitalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HospitalService {
    @Autowired
    private IHospitalRepository hospitalRepository;

    public List<HospitalDto> getAll() {
        return hospitalRepository.getAll();
    }

    public Optional<HospitalDto> get(int id) {
        return hospitalRepository.get(id);
    }

    public HospitalDto save(HospitalDto hospitalDto) {
        return hospitalRepository.save(hospitalDto);
    }

    public boolean delete (int id) {
        if (get(id).isPresent()) {
            hospitalRepository.delete(id);
            return true;
        } else {
            return false;
        }
    }
}
