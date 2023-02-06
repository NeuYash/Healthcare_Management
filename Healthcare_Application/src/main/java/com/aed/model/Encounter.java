/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.aed.model;

/**
 *
 * @author yashpawar
 */
public class Encounter {

    private int encounterID;
    private int patientId;
    private int vitalSignsId;
    private String dateOfEncounter;
    private String status; //can be enum("accepted","rejected","pending")
    private int doctorId;
    private int hospitalId;
    private String remark;

    public Encounter(int encounterID, int patientId, int vitalSignsId, String dateOfEncounter, String status, int doctorId, int hospitalId, String remark) {
        this.encounterID = encounterID;
        this.patientId = patientId;
        this.vitalSignsId = vitalSignsId;
        this.dateOfEncounter = dateOfEncounter;
        this.status = status;
        this.doctorId = doctorId;
        this.hospitalId = hospitalId;
        this.remark = remark;
    }

    public int getEncounterID() {
        return encounterID;
    }

    public void setEncounterID(int encounterID) {
        this.encounterID = encounterID;
    }

    public int getPatientId() {
        return patientId;
    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }

    public int getVitalSignsId() {
        return vitalSignsId;
    }

    public void setVitalSignsId(int vitalSignsId) {
        this.vitalSignsId = vitalSignsId;
    }

    public String getDateOfEncounter() {
        return dateOfEncounter;
    }

    public void setDateOfEncounter(String dateOfEncounter) {
        this.dateOfEncounter = dateOfEncounter;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(int doctorId) {
        this.doctorId = doctorId;
    }

    public int getHospitalId() {
        return hospitalId;
    }

    public void setHospitalId(int hospitalId) {
        this.hospitalId = hospitalId;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

}
