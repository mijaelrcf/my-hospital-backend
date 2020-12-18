package com.digitalharbor.myhospital.persistence.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "patients")
public class Patient extends Person {

    @ManyToOne
    @JoinColumn(name = "hospital_id", referencedColumnName = "id", nullable = false)
    private Hospital hospitals;

    @OneToMany(mappedBy = "patient", fetch = FetchType.LAZY)
    private Set<Record> records;

    public Hospital getHospitals() {
        return hospitals;
    }

    public void setHospitals(Hospital hospitals) {
        this.hospitals = hospitals;
    }

    public Set<Record> getRecords() {
        return records;
    }

    public void setRecords(Set<Record> records) {
        this.records = records;
    }
}
