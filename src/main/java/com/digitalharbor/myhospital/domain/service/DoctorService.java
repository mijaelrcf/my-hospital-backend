package com.digitalharbor.myhospital.domain.service;

import com.digitalharbor.myhospital.domain.dto.DoctorDto;
import com.digitalharbor.myhospital.domain.repository.IDoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DoctorService {
    @Autowired
    private IDoctorRepository iDoctorRepository;

    public List<DoctorDto> getAll() {
        return iDoctorRepository.getAll();
    }

    public Optional<DoctorDto> get(int id) {
        return iDoctorRepository.get(id);
    }

    public DoctorDto save(DoctorDto doctor) {
        return iDoctorRepository.save(doctor);
    }

    public boolean delete (int id) {
        if (get(id).isPresent()) {
            iDoctorRepository.delete(id);
            return true;
        } else {
            return false;
        }
    }
}
