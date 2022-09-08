package com.mahbubalam.blooddonationsystem.server.entity;

public class User {
    private  int userId ;
    private String name;
    private  String userEmail;
    private  String userPhoneNo;
    
    public static final User instanceOfUser = new User();
    
    public static User getInstance(){
        return instanceOfUser;
    }
    public User(int userId, String name, String userEmail, String userPhoneNo) {
        this.userId = userId;
        this.name = name;
        this.userEmail = userEmail;
        this.userPhoneNo = userPhoneNo;
    }



    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
        Person.getInstance().setId(userId);
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
        Person.getInstance().setEmail(userEmail);
    }

    public String getUserPhoneNo() {
        return userPhoneNo;
    }

    public void setUserPhoneNo(String userPhoneNo) {
        this.userPhoneNo = userPhoneNo;
        Person.getInstance().setPhoneNumber(userPhoneNo);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        Person.getInstance().setFirstName(name.split(" ")[0]);
        Person.getInstance().setLastName(name.split(" ")[1]);
    }

    public User() {
    }
}
