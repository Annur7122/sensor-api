package com.example.sensor_api.service;

import com.example.sensor_api.model.Measurement;
import com.example.sensor_api.model.Sensor;
import com.example.sensor_api.repository.MeasurementRepository;
import com.example.sensor_api.repository.SensorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MeasurementService {
    private final MeasurementRepository measurementRepository;
    private final SensorRepository sensorRepository;

    @Autowired
    public MeasurementService(MeasurementRepository measurementRepository, SensorRepository sensorRepository) {
        this.measurementRepository = measurementRepository;
        this.sensorRepository = sensorRepository;
    }

    public Measurement addMeasurement(Double value, Boolean raining, String sensorName) {
        Sensor sensor = sensorRepository.findByName(sensorName)
                .orElseThrow(() -> new IllegalArgumentException("Sensor not found"));

        Measurement measurement = new Measurement();
        measurement.setValue(value);
        measurement.setRaining(raining);
        measurement.setSensor(sensor);

        return measurementRepository.save(measurement);
    }

    public long countRainyDays() {
        return measurementRepository.countByRainingTrue();
    }

    public List<Measurement> getAllMeasurement(){
        return measurementRepository.findAll();
    }
}
