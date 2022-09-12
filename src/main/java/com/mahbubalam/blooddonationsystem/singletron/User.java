package com.mahbubalam.blooddonationsystem.singletron;


import com.mahbubalam.blooddonationsystem.util.NetworkUtility;

public class User {
    public static final User instance = new User();
    private int userId;
    private String name;
    private String userEmail;
    private String userPhoneNo;
    private NetworkUtility networkUtility;

    public NetworkUtility getNetworkUtility() {
        return networkUtility;
    }

    public void setNetworkUtility(NetworkUtility networkUtility) {
        this.networkUtility = networkUtility;
    }



    private User() {
    }

    public static User getInstance() {
        return instance;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserPhoneNo() {
        return userPhoneNo;
    }

    public void setUserPhoneNo(String userPhoneNo) {
        this.userPhoneNo = userPhoneNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
