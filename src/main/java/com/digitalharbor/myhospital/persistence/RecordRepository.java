package com.digitalharbor.myhospital.persistence;

import com.digitalharbor.myhospital.domain.dto.RecordDto;
import com.digitalharbor.myhospital.domain.repository.IRecordRepository;
import com.digitalharbor.myhospital.persistence.crud.DoctorCrudRepository;
import com.digitalharbor.myhospital.persistence.crud.HospitalCrudRepository;
import com.digitalharbor.myhospital.persistence.crud.PatientCrudRepository;
import com.digitalharbor.myhospital.persistence.crud.RecordCrudRepository;
import com.digitalharbor.myhospital.persistence.entity.Doctor;
import com.digitalharbor.myhospital.persistence.entity.Hospital;
import com.digitalharbor.myhospital.persistence.entity.Patient;
import com.digitalharbor.myhospital.persistence.entity.Record;
import com.digitalharbor.myhospital.persistence.mapper.RecordMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public class RecordRepository implements IRecordRepository {
    @Autowired
    private RecordCrudRepository recordCrudRepository;

    @Autowired
    private DoctorCrudRepository doctorCrudRepository;

    @Autowired
    private PatientCrudRepository patientCrudRepository;

    @Autowired
    private RecordMapper mapper;

    @Override
    public List<RecordDto> getAll() {
        List<Record> records = (List<Record>) recordCrudRepository.findAll();
        return mapper.toRecords(records);
    }

    @Override
    public Optional<RecordDto> get(int id) {
        return recordCrudRepository.findById(id).map(record -> mapper.toRecord(record));
    }

    @Override
    public Optional<List<RecordDto>> getByPatient(int patientId) {
        List<Record> records = (List<Record>) recordCrudRepository.findByPatientId(patientId); //.map(record -> mapper.toRecord(record));
        return Optional.of(mapper.toRecords(records));
    }

    @Override
    public RecordDto save (RecordDto recordDto){
        Record record = mapper.toRecord(recordDto);
        record.setCreatedDate(LocalDateTime.now());
        Optional<Doctor> optionalDoctor = doctorCrudRepository.findById(recordDto.getDoctorId());
        if (optionalDoctor.isPresent()) {
            record.setDoctor(optionalDoctor.get());
        }
        Optional<Patient> optionalPatient = patientCrudRepository.findById(recordDto.getPatientId());
        if (optionalPatient.isPresent()) {
            record.setPatient(optionalPatient.get());
        }
        return mapper.toRecord(recordCrudRepository.save(record));
    }

    @Override
    public void delete (int id){
        recordCrudRepository.deleteById(id);
    }
}
