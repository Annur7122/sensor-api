package com.example.sensor_api.controller;

import com.example.sensor_api.dto.MeasurementRequest;
import com.example.sensor_api.model.Measurement;
import com.example.sensor_api.service.MeasurementService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/measurements")
public class MeasurementController {

    private final MeasurementService measurementService;

    @Autowired
    public MeasurementController(MeasurementService measurementService) {
        this.measurementService = measurementService;
    }

    @PostMapping("/add")
    public ResponseEntity<Measurement> addMeasurement(@RequestBody MeasurementRequest request) {
        Measurement measurement = measurementService.addMeasurement(
                request.getValue(), request.getRaining(), request.getSensorName());

        return ResponseEntity.ok(measurement);
    }

    //чекни тут
    @GetMapping
    public ResponseEntity<List<Measurement>> getAllMeasurements(HttpServletRequest request){
        String username = (String) request.getAttribute("username");
        System.out.println("Запрос от пользователя: " + username);
        return ResponseEntity.ok(measurementService.getAllMeasurement());
    }

    @GetMapping("/rainyDaysCount")
    public ResponseEntity<Long> countRainyDays() {
        return ResponseEntity.ok(measurementService.countRainyDays());
    }
}