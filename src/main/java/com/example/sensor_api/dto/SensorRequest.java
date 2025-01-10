package com.example.sensor_api.dto;

public class SensorRequest {

    private String name;

    public SensorRequest() {

    }


    public SensorRequest(String name) {
        this.name = name;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
