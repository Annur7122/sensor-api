package com.example.sensor_api.service;

import com.example.sensor_api.model.Sensor;
import com.example.sensor_api.repository.SensorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SensorService {
    private final SensorRepository sensorRepository;

    @Autowired
    public SensorService(SensorRepository sensorRepository) {
        this.sensorRepository = sensorRepository;
    }

    public Sensor registerSensor(String name) {
        Optional<Sensor> existingSensor = sensorRepository.findByName(name);
        if(existingSensor.isPresent()) {
            throw new IllegalArgumentException("Sensor with this name already exists");
        }
        Sensor sensor = new Sensor();
        sensor.setName(name);
        return sensorRepository.save(sensor);
    }

    public Sensor findByName(String name) {
        return sensorRepository.findByName(name).orElseThrow(() ->
                new IllegalArgumentException("Sensor not found")
        );
    }
}
