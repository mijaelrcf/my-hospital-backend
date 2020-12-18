package com.digitalharbor.myhospital.persistence;

import com.digitalharbor.myhospital.domain.PatientDomain;
import com.digitalharbor.myhospital.domain.repository.IPatientRepository;
import com.digitalharbor.myhospital.persistence.crud.PatientCrudRepository;
import com.digitalharbor.myhospital.persistence.entity.Patient;
import com.digitalharbor.myhospital.persistence.mapper.PatientMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class PatientRepository implements IPatientRepository {
    @Autowired
    private PatientCrudRepository patientCrudRepository;

    @Autowired
    private PatientMapper mapper;

    @Override
    public List<PatientDomain> getAll() {
        List<Patient> patients = (List<Patient>) patientCrudRepository.findAll();
        return mapper.toPatients(patients);
    }

    @Override
    public Optional<PatientDomain> get(int id) {
        return patientCrudRepository.findById(id).map(patient -> mapper.toPatient(patient));
    }

    @Override
    public PatientDomain save (PatientDomain patientDomain){
        Patient patient = mapper.toPatient(patientDomain);
        return mapper.toPatient(patientCrudRepository.save(patient));
    }

    @Override
    public void delete (int id){
        patientCrudRepository.deleteById(id);
    }
}
