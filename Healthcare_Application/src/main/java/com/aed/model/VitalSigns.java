/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.aed.model;

/**
 *
 * @author yashpawar
 */
public class VitalSigns {
    
    private int vitalSignsId;
    private double temperature;
    private int bloodPressure;
    private int heartRate;

    public VitalSigns(int vitalSignsId, double temperature, int bloodPressure, int heartRate) {
        this.vitalSignsId = vitalSignsId;
        this.temperature = temperature;
        this.bloodPressure = bloodPressure;
        this.heartRate = heartRate;
    }
    
    public int getVitalSignsId() {
        return vitalSignsId;
    }

    public void setVitalSignsId(int vitalSignsId) {
        this.vitalSignsId = vitalSignsId;
    }

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    public int getBloodPressure() {
        return bloodPressure;
    }

    public void setBloodPressure(int bloodPressure) {
        this.bloodPressure = bloodPressure;
    }

    public int getHeartRate() {
        return heartRate;
    }

    public void setHeartRate(int bloodOxygen) {
        this.heartRate = bloodOxygen;
    }
    
    
}
