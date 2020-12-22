package com.digitalharbor.myhospital.persistence;

import com.digitalharbor.myhospital.domain.dto.DoctorDto;
import com.digitalharbor.myhospital.domain.repository.IDoctorRepository;
import com.digitalharbor.myhospital.persistence.crud.DoctorCrudRepository;
import com.digitalharbor.myhospital.persistence.crud.HospitalCrudRepository;
import com.digitalharbor.myhospital.persistence.crud.SpecialtyCrudRepository;
import com.digitalharbor.myhospital.persistence.entity.Doctor;
import com.digitalharbor.myhospital.persistence.entity.Hospital;
import com.digitalharbor.myhospital.persistence.entity.Specialty;
import com.digitalharbor.myhospital.persistence.mapper.DoctorMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Repository
public class DoctorRepository implements IDoctorRepository {
    @Autowired
    private DoctorCrudRepository doctorCrudRepository;

    @Autowired
    private HospitalCrudRepository hospitalCrudRepository;

    @Autowired
    private SpecialtyCrudRepository specialtyCrudRepository;

    @Autowired
    private DoctorMapper mapper;

    public DoctorRepository() {
    }

    @Override
    public List<DoctorDto> getAll() {
        List<Doctor> doctors = (List<Doctor>) doctorCrudRepository.findAll();
        return mapper.toDoctors(doctors);
    }

    @Override
    public Optional<DoctorDto> get(int id) {
        return doctorCrudRepository.findById(id).map(doctor -> mapper.toDoctor(doctor));
    }

    @Override
    public DoctorDto save (DoctorDto doctorDto){
        Doctor doctor = mapper.toDoctor(doctorDto);
        doctor.setCreatedDate(LocalDateTime.now());
        Optional<Hospital> optionalHospital = hospitalCrudRepository.findById(doctorDto.getHospitalId());
        if (optionalHospital.isPresent()) {
            doctor.setHospital(optionalHospital.get());
        }
        Optional<Specialty> optionalSpecialty = specialtyCrudRepository.findById(doctorDto.getSpecialtyId());
        if (optionalSpecialty.isPresent()) {
            doctor.getSpecialties().add(optionalSpecialty.get());
        }
        return mapper.toDoctor(doctorCrudRepository.save(doctor));
    }

    @Override
    public void delete (int id){
        doctorCrudRepository.deleteById(id);
    }
}
