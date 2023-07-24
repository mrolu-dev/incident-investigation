package com.example.repositories;

import com.example.models.Incident;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;


// import org.springframework.stereotype.Repository;

// @Repository
public interface IncidentRepository extends MongoRepository<Incident, String> {
    // Additional custom methods can be added if needed
    List<Incident> findByLocation(String location);

    List<Incident> findByDateBetween(String startDate, String endDate);

    List<Incident> findByIncidentType(String incidentType);

    List<Incident> findByIncidentClassification(String incidentClassification);

    List<Incident> findByLocationAndIncidentType(String location, String incidentType);
}
