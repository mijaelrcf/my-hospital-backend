package com.digitalharbor.myhospital.persistence;

import com.digitalharbor.myhospital.domain.RecordDomain;
import com.digitalharbor.myhospital.domain.repository.IRecordRepository;
import com.digitalharbor.myhospital.persistence.crud.RecordCrudRepository;
import com.digitalharbor.myhospital.persistence.entity.Record;
import com.digitalharbor.myhospital.persistence.mapper.RecordMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class RecordRepository implements IRecordRepository {
    @Autowired
    private RecordCrudRepository recordCrudRepository;

    @Autowired
    private RecordMapper mapper;

    @Override
    public List<RecordDomain> getAll() {
        List<Record> records = (List<Record>) recordCrudRepository.findAll();
        return mapper.toRecords(records);
    }

    @Override
    public Optional<RecordDomain> get(int id) {
        return recordCrudRepository.findById(id).map(record -> mapper.toRecord(record));
    }

    @Override
    public RecordDomain save (RecordDomain recordDomain){
        Record record = mapper.toRecord(recordDomain);
        return mapper.toRecord(recordCrudRepository.save(record));
    }

    @Override
    public void delete (int id){
        recordCrudRepository.deleteById(id);
    }
}
