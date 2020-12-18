package com.digitalharbor.myhospital.persistence;

import com.digitalharbor.myhospital.domain.dto.DoctorDto;
import com.digitalharbor.myhospital.domain.repository.IDoctorRepository;
import com.digitalharbor.myhospital.persistence.crud.DoctorCrudRepository;
import com.digitalharbor.myhospital.persistence.entity.Doctor;
import com.digitalharbor.myhospital.persistence.mapper.DoctorMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class DoctorRepository implements IDoctorRepository {
    @Autowired
    private DoctorCrudRepository doctorCrudRepository;

    @Autowired
    private DoctorMapper mapper;

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
        return mapper.toDoctor(doctorCrudRepository.save(doctor));
    }

    @Override
    public void delete (int id){
        doctorCrudRepository.deleteById(id);
    }
}
