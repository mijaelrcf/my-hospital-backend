package com.digitalharbor.myhospital.domain.service;

import com.digitalharbor.myhospital.domain.dto.PatientDto;
import com.digitalharbor.myhospital.domain.repository.IPatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PatientService {
    @Autowired
    private IPatientRepository patientRepository;

    public List<PatientDto> getAll() {
        return patientRepository.getAll();
    }

    public Optional<PatientDto> get(int id) {
        return patientRepository.get(id);
    }

    public PatientDto save(PatientDto patient) {
        return patientRepository.save(patient);
    }

    public boolean delete (int id) {
        if (get(id).isPresent()) {
            patientRepository.delete(id);
            return true;
        } else {
            return false;
        }
    }
}
