package com.digitalharbor.myhospital.persistence;

import com.digitalharbor.myhospital.domain.dto.SpecialtyDto;
import com.digitalharbor.myhospital.domain.repository.ISpecialtyRepository;
import com.digitalharbor.myhospital.persistence.crud.SpecialtyCrudRepository;
import com.digitalharbor.myhospital.persistence.entity.Specialty;
import com.digitalharbor.myhospital.persistence.mapper.SpecialtyMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public class SpecialtyRepository implements ISpecialtyRepository {
    @Autowired
    private SpecialtyCrudRepository specialtyCrudRepository;

    @Autowired
    private SpecialtyMapper mapper;

    @Override
    public List<SpecialtyDto> getAll() {
        List<Specialty> specialtys = (List<Specialty>) specialtyCrudRepository.findAll();
        return mapper.toSpecialtys(specialtys);
    }

    @Override
    public Optional<SpecialtyDto> get(int id) {
        return specialtyCrudRepository.findById(id).map(specialty -> mapper.toSpecialty(specialty));
    }

    @Override
    public SpecialtyDto save (SpecialtyDto specialtyDto){
        Specialty specialty = mapper.toSpecialty(specialtyDto);
        specialty.setCreatedDate(LocalDateTime.now());
        return mapper.toSpecialty(specialtyCrudRepository.save(specialty));
    }

    @Override
    public SpecialtyDto update (SpecialtyDto specialtyDto){
        Specialty specialty = mapper.toSpecialty(specialtyDto);
        specialty.setUpdatedDate(LocalDateTime.now());
        return mapper.toSpecialty(specialtyCrudRepository.save(specialty));
    }

    @Override
    public void delete (int id){
        specialtyCrudRepository.deleteById(id);
    }
}
