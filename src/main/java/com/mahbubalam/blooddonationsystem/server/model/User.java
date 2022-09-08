package com.mahbubalam.blooddonationsystem.server.model;


public class User {
    public static final User instanceOfUser = new User();
    private int userId;
    private String name;
    private String userEmail;
    private String userPhoneNo;

    public User(int userId, String name, String userEmail, String userPhoneNo) {
        this.userId = userId;
        this.name = name;
        this.userEmail = userEmail;
        this.userPhoneNo = userPhoneNo;
    }

    public User() {
    }

    public static User getInstance() {
        return instanceOfUser;
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
