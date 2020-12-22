package com.digitalharbor.myhospital.domain.service;

import com.digitalharbor.myhospital.domain.dto.RecordDto;
import com.digitalharbor.myhospital.domain.repository.IRecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RecordService {
    @Autowired
    private IRecordRepository iRecordRepository;

    public List<RecordDto> getAll() {
        return iRecordRepository.getAll();
    }

    public Optional<RecordDto> get(int id) {
        return iRecordRepository.get(id);
    }

    public RecordDto save(RecordDto record) {
        return iRecordRepository.save(record);
    }

    public boolean delete (int id) {
        if (get(id).isPresent()) {
            iRecordRepository.delete(id);
            return true;
        } else {
            return false;
        }
    }
}
