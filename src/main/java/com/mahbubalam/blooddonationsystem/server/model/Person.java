package com.mahbubalam.blooddonationsystem.server.model;

import com.mahbubalam.blooddonationsystem.server.entity.BloodGroup;
import com.mahbubalam.blooddonationsystem.server.entity.Gender;
import com.mahbubalam.blooddonationsystem.server.entity.Password;

public class Person {
    public  static final Person instance = new Person();

    public static final Person getInstanceOfModelPerson(){
        return instance;
    }
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String email;
    private String dateOfBirth;
    private BloodGroup bloodGroup;
    private Gender gender;

    public Person() {
    }


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }


    public BloodGroup getBloodGroup() {
        return bloodGroup;
    }

    public void setBloodGroup(BloodGroup bloodGroup) {
        this.bloodGroup = bloodGroup;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }
}
