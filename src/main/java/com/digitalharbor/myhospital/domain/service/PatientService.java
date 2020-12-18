package com.digitalharbor.myhospital.domain.service;

import com.digitalharbor.myhospital.domain.PatientDomain;
import com.digitalharbor.myhospital.domain.repository.IPatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PatientService {
    @Autowired
    private IPatientRepository patientRepository;

    public List<PatientDomain> getAll() {
        return patientRepository.getAll();
    }

    public Optional<PatientDomain> get(int id) {
        return patientRepository.get(id);
    }

    public PatientDomain save(PatientDomain patient) {
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
