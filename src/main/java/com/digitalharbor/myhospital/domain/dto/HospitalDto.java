package com.digitalharbor.myhospital.domain.dto;

import java.util.Set;

public class HospitalDto {
    private Integer id;
    private String name;
    private String createdBy;
    private String updatedBy;
    //private Set<PatientDomain> patients;
    //private Set<DoctorDto> doctors;

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

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }
    //    public Set<PatientDomain> getPatients() {
//        return patients;
//    }
//
//    public void setPatients(Set<PatientDomain> patients) {
//        this.patients = patients;
//    }
//
//    public Set<DoctorDto> getDoctors() {
//        return doctors;
//    }
//
//    public void setDoctors(Set<DoctorDto> doctors) {
//        this.doctors = doctors;
//    }
}
