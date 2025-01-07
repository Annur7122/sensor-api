package com.example.sensor_api.dto;

public class MeasurementRequest {
    private Double value;
    private Boolean raining;

    private String sensorName;

    public MeasurementRequest(){

    }
    public MeasurementRequest(Double value, String sensorName, Boolean raining) {
        this.value = value;
        this.sensorName = sensorName;
        this.raining = raining;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public Boolean getRaining() {
        return raining;
    }

    public void setRaining(Boolean raining) {
        this.raining = raining;
    }

    public String getSensorName() {
        return sensorName;
    }

    public void setSensorName(String sensorName) {
        this.sensorName = sensorName;
    }
}
