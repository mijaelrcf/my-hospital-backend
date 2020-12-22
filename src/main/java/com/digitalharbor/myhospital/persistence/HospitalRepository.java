package com.digitalharbor.myhospital.persistence;

import com.digitalharbor.myhospital.domain.dto.HospitalDto;
import com.digitalharbor.myhospital.domain.repository.IHospitalRepository;
import com.digitalharbor.myhospital.persistence.crud.HospitalCrudRepository;
import com.digitalharbor.myhospital.persistence.entity.Hospital;
import com.digitalharbor.myhospital.persistence.mapper.HospitalMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public class HospitalRepository implements IHospitalRepository {
    @Autowired
    private HospitalCrudRepository hospitalCrudRepository;

    @Autowired
    private HospitalMapper mapper;

    @Override
    public List<HospitalDto> getAll() {
        List<Hospital> hospitals = (List<Hospital>) hospitalCrudRepository.findAll();
        return mapper.toHospitals(hospitals);
    }

    @Override
    public Optional<HospitalDto> get(int id) {
        return hospitalCrudRepository.findById(id).map(hospital -> mapper.toHospital(hospital));
    }

    @Override
    public HospitalDto save (HospitalDto hospitalDto){
        Hospital hospital = mapper.toHospital(hospitalDto);
        hospital.setCreatedDate(LocalDateTime.now());
        return mapper.toHospital(hospitalCrudRepository.save(hospital));
    }

    @Override
    public HospitalDto update (HospitalDto hospitalDto){
        Hospital hospital = mapper.toHospital(hospitalDto);
        hospital.setUpdatedDate(LocalDateTime.now());
        return mapper.toHospital(hospitalCrudRepository.save(hospital));
    }

    @Override
    public void delete (int id){
        hospitalCrudRepository.deleteById(id);
    }
}
