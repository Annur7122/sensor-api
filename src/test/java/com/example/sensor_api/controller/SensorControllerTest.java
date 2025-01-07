package com.example.sensor_api.controller;

import com.example.sensor_api.dto.SensorRequest;
import com.example.sensor_api.model.Sensor;
import com.example.sensor_api.service.SensorService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.http.ResponseEntity;
import org.springframework.test.util.ReflectionTestUtils;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class SensorControllerTest {

    @Mock
    private SensorService sensorService;

    @InjectMocks
    private SensorController sensorController;

    @Test
    public void testRegisterSensor_Success() {
        SensorRequest request = new SensorRequest();
        request.setName("Sensor1");

        Sensor sensor = new Sensor();
        sensor.setName("Sensor1");

        when(sensorService.registerSensor(anyString())).thenReturn(sensor);

        ResponseEntity<Sensor> response = sensorController.registerSensor(String.valueOf(request));

        assertEquals(201, response.getStatusCodeValue());
        assertNotNull(response.getBody());
        assertEquals("Sensor1", response.getBody().getName());
    }

    @Test
    public void testRegisterSensor_SensorAlreadyExists() {
        SensorRequest request = new SensorRequest();
        request.setName("Sensor1");

        when(sensorService.registerSensor(anyString())).thenThrow(Exception.class);

        ResponseEntity<Sensor> response = sensorController.registerSensor(String.valueOf(request));

        assertEquals(400, response.getStatusCodeValue());
        assertNull(response.getBody());
    }
}
