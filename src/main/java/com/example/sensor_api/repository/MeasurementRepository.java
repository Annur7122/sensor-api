package com.example.sensor_api.repository;

import com.example.sensor_api.model.Measurement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MeasurementRepository extends JpaRepository<Measurement, Long> {
    long countByRainingTrue();
}
