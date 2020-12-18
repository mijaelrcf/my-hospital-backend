package com.digitalharbor.myhospital.domain.service;

import com.digitalharbor.myhospital.domain.HospitalDomain;
import com.digitalharbor.myhospital.domain.repository.IHospitalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Optional;

@Service
public class HospitalService {
    @Autowired
    private IHospitalRepository hospitalRepository;

    public List<HospitalDomain> getAll() {
        return hospitalRepository.getAll();
    }

    public Optional<HospitalDomain> get(int id) {
        return hospitalRepository.get(id);
    }

    public HospitalDomain save(HospitalDomain hospitalDomain) {
        return hospitalRepository.save(hospitalDomain);
    }

    public boolean delete (int id) {
        if (get(id).isPresent()) {
            hospitalRepository.delete(id);
            return true;
        } else {
            return false;
        }
    }
}
