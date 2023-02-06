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
public class Community {

    private int communityId;
    private String name;
    private String city;
    private String zipcode;
    private int personId;
    private List<Integer> houseId;
    private List<Integer> hospitalId;

    public Community(int communityId, String name, String city, String zipcode,
            List<Integer> houseId, List<Integer> hospitalId, int personId) {
        this.communityId = communityId;
        this.name = name;
        this.city = city;
        this.zipcode = zipcode;
        this.hospitalId = hospitalId;
        this.houseId = houseId;
        this.personId = personId;
    }

    public int getCommunityId() {
        return communityId;
    }

    public void setCommunityId(int communityId) {
        this.communityId = communityId;
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

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public List<Integer> getHospitalId() {
        return hospitalId;
    }

    public void setHospitalId(List<Integer> hospitalId) {
        this.hospitalId = hospitalId;
    }

    public List<Integer> getHouseId() {
        return houseId;
    }

    public void setHouseId(List<Integer> houseId) {
        this.houseId = houseId;
    }

    public int getPersonId() {
        return personId;
    }

    public void setPersonId(int personId) {
        this.personId = personId;
    }
}
