package com.example.lab51;

public class Admin extends User {
    private String adminRole;

    public Admin(String fullName, String gender, int age, String adminRole) {
        super(fullName, gender, age);
        this.adminRole = adminRole;
    }

    public String getAdminRole() {
        return adminRole;
    }

    public void setAdminRole(String adminRole) {
        this.adminRole = adminRole;
    }

    @Override
    public void getSummary() {
        System.out.println("Admin: " + getFullName());
        System.out.println("Gender: " + getGender());
        System.out.println("Age: " + getAge());
        System.out.println("Admin Role: " + adminRole);
    }
}