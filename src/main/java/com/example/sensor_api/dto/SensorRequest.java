package com.example.sensor_api.dto;

public class SensorRequest {

    private String name;

    public SensorRequest() {

    }

    // Constructor
    public SensorRequest(String name) {
        this.name = name;
    }

    // Getter and Setter for name
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
