package com.digitalharbor.myhospital.web.config;

import com.digitalharbor.myhospital.domain.dto.DoctorDto;
import com.digitalharbor.myhospital.domain.dto.HospitalDto;
import com.digitalharbor.myhospital.domain.dto.SpecialtyDto;
import com.digitalharbor.myhospital.domain.repository.IDoctorRepository;
import com.digitalharbor.myhospital.domain.repository.IHospitalRepository;
import com.digitalharbor.myhospital.domain.repository.IPatientRepository;
import com.digitalharbor.myhospital.domain.repository.ISpecialtyRepository;
import com.digitalharbor.myhospital.persistence.entity.Doctor;
import com.digitalharbor.myhospital.persistence.entity.Hospital;
import com.digitalharbor.myhospital.persistence.entity.Specialty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Component
public class DBSeeder {

    private final JdbcTemplate jdbcTemplate;
    private final IHospitalRepository iHospitalRepository;
    private final ISpecialtyRepository iSpecialtyRepository;
    private final IDoctorRepository iDoctorRepository;
    private final IPatientRepository iPatientRepository;

    @Autowired
    public DBSeeder(JdbcTemplate jdbcTemplate,
                    IHospitalRepository iHospitalRepository,
                    ISpecialtyRepository iSpecialtyRepository,
                    IDoctorRepository iDoctorRepository,
                    IPatientRepository iPatientRepository) {
        this.jdbcTemplate = jdbcTemplate;
        this.iHospitalRepository = iHospitalRepository;
        this.iSpecialtyRepository = iSpecialtyRepository;
        this.iDoctorRepository = iDoctorRepository;
        this.iPatientRepository = iPatientRepository;
    }

    @EventListener
    public void seed(ContextRefreshedEvent event) throws ParseException {
        seedHospitals();
        seedSpecialities();
        //seedDoctors();
        //seedPatients();
    }

    private void seedHospitals() {
        String sql = "SELECT * FROM hospitals";
        List<Hospital> hospitals = jdbcTemplate.query(sql, (resultSet, rowNum) -> null);
        if (hospitals.size() <= 0) {
            System.out.println("Hospitals table seeding...");

            HospitalDto h1 = new HospitalDto();
            h1.setName("Hospital General");
            h1.setCreatedBy("mcallejas");
            HospitalDto h2 = new HospitalDto();
            h2.setName("Hospital de Clinicas");
            h2.setCreatedBy("mcallejas");
            HospitalDto h3 = new HospitalDto();
            h3.setName("Hospital del Norte");
            h3.setCreatedBy("mcallejas");

            iHospitalRepository.save(h1);
            iHospitalRepository.save(h2);
            iHospitalRepository.save(h3);

            System.out.println("Hospitals table seeded");
        } else {
            System.out.println("Hospitals Seeding Not Required");
        }
    }

    private void seedSpecialities() {
        String sql = "SELECT * FROM specialties";
        List<Specialty> specialties = jdbcTemplate.query(sql, (resultSet, rowNum) -> null);
        if (specialties.size() <= 0) {
            System.out.println("Specialties table seeding...");

            SpecialtyDto s1 = new SpecialtyDto();
            s1.setName("Anestesiología");
            s1.setDescription("Descripcion Anestesiología");

            SpecialtyDto s2 = new SpecialtyDto();
            s2.setName("Cardiología");
            s2.setDescription("Descripcion Cardiología");

            SpecialtyDto s3 = new SpecialtyDto();
            s3.setName("Dermatología");
            s3.setDescription("Descripcion Cardiología");

            iSpecialtyRepository.save(s1);
            iSpecialtyRepository.save(s2);
            iSpecialtyRepository.save(s3);

            System.out.println("Specialties table seeded");
        } else {
            System.out.println("Specialties Seeding Not Required");
        }
    }

    private void seedDoctors() {
        String sql = "SELECT * FROM doctors";
        Optional<HospitalDto> hospital = iHospitalRepository.get(1);
        Optional<SpecialtyDto> specialty = iSpecialtyRepository.get(1);
        List<Doctor> doctors = jdbcTemplate.query(sql, (resultSet, rowNum) -> null);
        if (doctors.size() <= 0) {
            System.out.println("Doctors table seeding...");

            DoctorDto d1 = new DoctorDto();
            d1.setName("Juan");
            d1.setLastName("Perez");
            d1.setBirthdate(LocalDateTime.parse("1980-05-05"));
            d1.setAddress("Zona Sur, Calle 10 #100");
            d1.setHospitalId(hospital.get().getId());
            d1.setSpecialtyId(specialty.get().getId());

            DoctorDto d2 = new DoctorDto();
            d2.setName("Jose");
            d2.setLastName("Luna");
            d2.setBirthdate(LocalDateTime.parse("1982-01-01"));
            d2.setAddress("Zona Sur, Calle 15 #200");
            d2.setHospitalId(hospital.get().getId());
            d2.setSpecialtyId(specialty.get().getId());

            DoctorDto d3 = new DoctorDto();
            d3.setName("Pablo");
            d3.setLastName("Lujan");
            d3.setBirthdate(LocalDateTime.parse("1985-05-02"));
            d3.setAddress("Zona Sur, Calle 11 #310");
            d3.setHospitalId(hospital.get().getId());
            d3.setSpecialtyId(specialty.get().getId());

            iDoctorRepository.save(d1);
            iDoctorRepository.save(d2);
            iDoctorRepository.save(d3);

            System.out.println("Doctors table seeded");
        } else {
            System.out.println("Doctors Seeding Not Required");
        }
    }

    private void seedPatients() {
    }
}
