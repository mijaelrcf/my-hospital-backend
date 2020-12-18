package com.digitalharbor.myhospital.persistence.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Set;

@Entity
@Table(name = "hospitals")
public class Hospital extends BaseEntity{

    private String name;

    @OneToMany(mappedBy = "hospitals", fetch = FetchType.LAZY)
    private Set<Doctor> doctors;

    @OneToMany(mappedBy = "hospitals", fetch = FetchType.LAZY)
    private Set<Patient> patients;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Doctor> getDoctors() {
        return doctors;
    }

    public void setDoctors(Set<Doctor> doctors) {
        this.doctors = doctors;
    }

    public Set<Patient> getPatients() {
        return patients;
    }

    public void setPatients(Set<Patient> patients) {
        this.patients = patients;
    }
}
