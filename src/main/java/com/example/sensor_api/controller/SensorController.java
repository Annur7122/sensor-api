package com.example.sensor_api.controller;

import com.example.sensor_api.model.Sensor;
import com.example.sensor_api.service.SensorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sensors")
public class SensorController {

    private final SensorService sensorService;

    @Autowired
    public SensorController(SensorService sensorService) {
        this.sensorService = sensorService;
    }

    @PostMapping("/registration")
    public ResponseEntity<Sensor> registerSensor(@RequestBody String name) {
        Sensor sensor = sensorService.registerSensor(name);
        return ResponseEntity.ok(sensor);
    }

}
