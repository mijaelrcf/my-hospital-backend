package com.digitalharbor.myhospital.persistence;

import com.digitalharbor.myhospital.domain.dto.PatientDto;
import com.digitalharbor.myhospital.domain.repository.IPatientRepository;
import com.digitalharbor.myhospital.persistence.crud.HospitalCrudRepository;
import com.digitalharbor.myhospital.persistence.crud.PatientCrudRepository;
import com.digitalharbor.myhospital.persistence.entity.Hospital;
import com.digitalharbor.myhospital.persistence.entity.Patient;
import com.digitalharbor.myhospital.persistence.mapper.PatientMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public class PatientRepository implements IPatientRepository {
    @Autowired
    private PatientCrudRepository patientCrudRepository;

    @Autowired
    private HospitalCrudRepository hospitalCrudRepository;

    @Autowired
    private PatientMapper mapper;

    @Override
    public List<PatientDto> getAll() {
        List<Patient> patients = (List<Patient>) patientCrudRepository.findAll();
        return mapper.toPatients(patients);
    }

    @Override
    public Optional<PatientDto> get(int id) {
        return patientCrudRepository.findById(id).map(patient -> mapper.toPatient(patient));
    }

    @Override
    public PatientDto save (PatientDto patientDto) {
        Patient patient = mapper.toPatient(patientDto);
        patient.setCreatedDate(LocalDateTime.now());
        Optional<Hospital> optionalHospital = hospitalCrudRepository.findById(patientDto.getHospitalId());
        if (optionalHospital.isPresent()) {
            patient.setHospital(optionalHospital.get());
        }
        return mapper.toPatient(patientCrudRepository.save(patient));
    }

    @Override
    public void delete (int id){
        patientCrudRepository.deleteById(id);
    }
}
