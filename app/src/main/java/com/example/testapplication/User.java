package com.example.testapplication;

public class User
{
    private String name;
    private int age;
    private char gender;
    private String phone;
    private boolean phoneVisible;

    public User(String name, int age, char gender, String phone, boolean phoneVisible) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.phone = phone;
        this.phoneVisible = phoneVisible;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public boolean isPhoneVisible() {
        return phoneVisible;
    }

    public void setPhoneVisible(boolean phoneVisible) {
        this.phoneVisible = phoneVisible;
    }
}
