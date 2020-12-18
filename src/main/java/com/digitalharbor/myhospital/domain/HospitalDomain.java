package com.digitalharbor.myhospital.domain;

import java.util.List;
import java.util.Set;

public class HospitalDomain {
    private Integer id;
    private String name;
    private Set<PatientDomain> patients;
    private Set<DoctorDomain> doctors;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<PatientDomain> getPatients() {
        return patients;
    }

    public void setPatients(Set<PatientDomain> patients) {
        this.patients = patients;
    }

    public Set<DoctorDomain> getDoctors() {
        return doctors;
    }

    public void setDoctors(Set<DoctorDomain> doctors) {
        this.doctors = doctors;
    }
}
