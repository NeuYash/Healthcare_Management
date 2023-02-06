package com.aed.model;

/**
 *
 * @author yashpawar
 */
public class Person {

    private int personID;
    private String name;
    private String userName;
    private String password;
    private String role;
    private int age;
    private String gender;
    private String photo;
    private int houseID;

    public Person(int personID, String name, String userName, String password, String role, int age, String gender, String photo, int houseID) {
        this.personID = personID;
        this.name = name;
        this.userName = userName;
        this.password = password;
        this.role = role;
        this.age = age;
        this.gender = gender;
        this.photo = photo;
        this.houseID = houseID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getPersonID() {
        return personID;
    }

    public void setPersonID(int personID) {
        this.personID = personID;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public int getHouseID() {
        return houseID;
    }

    public void setHouseID(int houseID) {
        this.houseID = houseID;
    }
}
