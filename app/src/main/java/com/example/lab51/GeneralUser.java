package com.example.lab51;

public class GeneralUser extends User {
    private String userRole;

    public GeneralUser(String fullName, String gender, int age, String userRole) {
        super(fullName, gender, age);
        this.userRole = userRole;
    }

    public String getUserRole() {
        return userRole;
    }

    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }

    @Override
    public void getSummary() {
        System.out.println("General User: " + getFullName());
        System.out.println("Gender: " + getGender());
        System.out.println("Age: " + getAge());
        System.out.println("User Role: " + userRole);
    }
}