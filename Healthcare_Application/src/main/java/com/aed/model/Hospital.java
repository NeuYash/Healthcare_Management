/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.aed.model;

import java.util.List;

/**
 *
 * @author yashpawar
 */
public class Hospital {

    private int hospitalId;
    private String name;
    private String city;
    private int personId;
    private List<Integer> communityId;
    private List<Integer> docterId;

    public Hospital(int hospitalId, String name, String city, List<Integer> communityId,
            List<Integer> docterId, int personId) {
        this.hospitalId = hospitalId;
        this.name = name;
        this.city = city;
        this.communityId = communityId;
        this.docterId = docterId;
        this.personId=personId;
    }
    
    public int getHospitalId() {
        return hospitalId;
    }

    public void setHospitalId(int hospitalId) {
        this.hospitalId = hospitalId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getPersonId() {
        return personId;
    }

    public void setPersonId(int personId) {
        this.personId = personId;
    }

    public List<Integer> getCommunityId() {
        return communityId;
    }

    public void setCommunityId(List<Integer> communityId) {
        this.communityId = communityId;
    }

    public List<Integer> getDocterId() {
        return docterId;
    }

    public void setDocterId(List<Integer> docterId) {
        this.docterId = docterId;
    }

}
