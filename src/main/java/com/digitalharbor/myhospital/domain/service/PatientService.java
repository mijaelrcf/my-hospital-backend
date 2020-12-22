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
    private IPatientRepository iPatientRepository;

    public List<PatientDto> getAll() {
        return iPatientRepository.getAll();
    }

    public Optional<PatientDto> get(int id) {
        return iPatientRepository.get(id);
    }

    public PatientDto save(PatientDto patient) {
        return iPatientRepository.save(patient);
    }

    public boolean delete (int id) {
        if (get(id).isPresent()) {
            iPatientRepository.delete(id);
            return true;
        } else {
            return false;
        }
    }
}
