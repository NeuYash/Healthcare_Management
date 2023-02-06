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
public class Docter {

    private int docterId;
    private int personId;
    private List<Integer> hospitalId;

    public Docter(int docterId, int personId, List<Integer> hospitalId) {
        this.docterId = docterId;
        this.personId = personId;
        this.hospitalId = hospitalId;
    }
    
    public int getDocterId() {
        return docterId;
    }

    public void setDocterId(int docterId) {
        this.docterId = docterId;
    }

    public int getPersonId() {
        return personId;
    }

    public void setPersonId(int personId) {
        this.personId = personId;
    }
    

    public List<Integer> getHospitalId() {
        return hospitalId;
    }

    public void setHospitalId(List<Integer> hospitalId) {
        this.hospitalId = hospitalId;
    }

}
