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
    private IHospitalRepository iHospitalRepository;

    public List<HospitalDto> getAll() {
        return iHospitalRepository.getAll();
    }

    public Optional<HospitalDto> get(int id) {
        return iHospitalRepository.get(id);
    }

    public HospitalDto save(HospitalDto hospitalDto) {
        return iHospitalRepository.save(hospitalDto);
    }

    public HospitalDto update(HospitalDto hospitalDto) {
        return iHospitalRepository.update(hospitalDto);
    }

    public boolean delete (int id) {
        if (get(id).isPresent()) {
            iHospitalRepository.delete(id);
            return true;
        } else {
            return false;
        }
    }
}
