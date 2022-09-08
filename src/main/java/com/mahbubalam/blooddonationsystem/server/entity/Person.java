package com.mahbubalam.blooddonationsystem.server.entity;


import java.util.List;

public class Person {

    public static final Person personInstance = new Person();

    public static Person getInstance(){
        return personInstance;
    }
    private int id;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String email;
    private String dateOfBirth;
    private Password password;
    private BloodGroup bloodGroup;
    private Gender gender;
    private Address address;
    private boolean readyToDonate = true;
    private boolean needBlood;
    private List<Donation> givenDonation;
    private List<Donation> receivedDonation;
    int addressId;
    int passwordId;

    public Person() {
    }

    public Person(String firstName, String lastName, String phoneNumber, String email, String dateOfBirth, BloodGroup bloodGroup, Gender gender) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.dateOfBirth = dateOfBirth;
        this.bloodGroup = bloodGroup;
        this.gender = gender;
    }

    public int getAddressId() {
        return addressId;
    }

    public void setAddressId(int addressId) {
        this.addressId = addressId;
    }

    public int getPasswordId() {
        return passwordId;
    }

    public void setPasswordId(int passwordId) {
        this.passwordId = passwordId;
    }


    public void setId(int id) {
        this.id = id;
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

    public Password getPassword() {
        return password;
    }

    public void setPassword(Password password) {
        this.password = password;
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

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public boolean isReadyToDonate() {
        return readyToDonate;
    }

    public void setReadyToDonate(boolean readyToDonate) {
        this.readyToDonate = readyToDonate;
    }

    public List<Donation> getGivenDonation() {
        return givenDonation;
    }

    public void setGivenDonation(List<Donation> givenDonation) {
        this.givenDonation = givenDonation;
    }

    public List<Donation> getReceivedDonation() {
        return receivedDonation;
    }

    public void setReceivedDonation(List<Donation> receivedDonation) {
        this.receivedDonation = receivedDonation;
    }

    public int getId() {
        return id;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth =dateOfBirth;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", email='" + email + '\'' +
                ", password=" + password +
                ", bloodGroup=" + bloodGroup +
                ", gender=" + gender +
                ", address=" + address +
                ", readyToDonate=" + readyToDonate +
                ", givenDonation=" + givenDonation +
                ", receivedDonation=" + receivedDonation +
                '}';
    }

    public boolean isNeedBlood() {
        return needBlood;
    }

    public void setNeedBlood(boolean needBlood) {
        this.needBlood = needBlood;
    }
}