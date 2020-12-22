package com.digitalharbor.myhospital.persistence.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "patients")
public class Patient extends Person {

    @ManyToOne
    @JoinColumn(name = "hospital_id", referencedColumnName = "id", nullable = false)
    private Hospital hospital;

    @OneToMany(mappedBy = "patient", fetch = FetchType.LAZY)
    private Set<Record> records;

    public Hospital getHospital() {
        return hospital;
    }

    public void setHospital(Hospital hospital) {
        this.hospital = hospital;
    }

    public Set<Record> getRecords() {
        return records;
    }

    public void setRecords(Set<Record> records) {
        this.records = records;
    }
}
