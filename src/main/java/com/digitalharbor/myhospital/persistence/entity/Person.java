package com.digitalharbor.myhospital.persistence.entity;

import org.hibernate.annotations.common.reflection.XProperty;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "person")
public class Person {

    private String lastName;
    private String birthdate;
    private String direction;
    private String profilePicture;

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public String getProfilePicture() {
        return profilePicture;
    }

    public void setProfilePicture(String profilePicture) {
        this.profilePicture = profilePicture;
    }
}
