package com.example.sensor_api.controller;

import com.example.sensor_api.controller.MeasurementController;
import com.example.sensor_api.dto.MeasurementRequest;
import com.example.sensor_api.model.Measurement;
import com.example.sensor_api.service.MeasurementService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;


public class MeasurementControllerTest {

    @Mock
    private MeasurementService measurementService;

    @InjectMocks
    private MeasurementController measurementController;

    @Test
    public void testAddMeasurement() {
        MeasurementRequest request = new MeasurementRequest();
        request.setValue(25.5);
        request.setRaining(true);
        request.setSensorName("Sensor1");

        Measurement measurement = new Measurement();
        measurement.setValue(25.5);
        measurement.setRaining(true);

        when(measurementService.addMeasurement(anyDouble(), anyBoolean(), anyString())).thenReturn(measurement);

        ResponseEntity<Measurement> response = measurementController.addMeasurement(request);

        assertEquals(200, response.getStatusCodeValue());
        assertNotNull(response.getBody());
        assertEquals(25.5, response.getBody().getValue());
        assertTrue(response.getBody().getRaining());
    }

    @Test
    public void testGetAllMeasurements() {
        List<Measurement> measurements = Arrays.asList(new Measurement(1L, 25.5, true, null));
        when(measurementService.getAllMeasurement()).thenReturn(measurements);

        ResponseEntity<List<Measurement>> response = measurementController.getAllMeasurements();

        assertEquals(200, response.getStatusCodeValue());
        assertEquals(1, response.getBody().size());
        assertEquals(25.5, response.getBody().get(0).getValue(), 0.001);
    }

    @Test
    public void testCountRainyDays() {
        when(measurementService.countRainyDays()).thenReturn(5L);

        ResponseEntity<Long> response = measurementController.countRainyDays();

        assertEquals(200, response.getStatusCodeValue());
        assertEquals(5L, response.getBody());
    }
}
