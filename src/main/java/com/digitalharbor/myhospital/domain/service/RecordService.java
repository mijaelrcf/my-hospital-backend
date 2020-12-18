package com.digitalharbor.myhospital.domain.service;

import com.digitalharbor.myhospital.domain.RecordDomain;
import com.digitalharbor.myhospital.domain.repository.IRecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RecordService {
    @Autowired
    private IRecordRepository recordRepository;

    public List<RecordDomain> getAll() {
        return recordRepository.getAll();
    }

    public Optional<RecordDomain> get(int id) {
        return recordRepository.get(id);
    }

    public RecordDomain save(RecordDomain record) {
        return recordRepository.save(record);
    }

    public boolean delete (int id) {
        if (get(id).isPresent()) {
            recordRepository.delete(id);
            return true;
        } else {
            return false;
        }
    }
}
