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
    private IDoctorRepository doctorRepository;

    public List<DoctorDto> getAll() {
        return doctorRepository.getAll();
    }

    public Optional<DoctorDto> get(int id) {
        return doctorRepository.get(id);
    }

    public DoctorDto save(DoctorDto doctor) {
        return doctorRepository.save(doctor);
    }

    public boolean delete (int id) {
        if (get(id).isPresent()) {
            doctorRepository.delete(id);
            return true;
        } else {
            return false;
        }
    }
}
