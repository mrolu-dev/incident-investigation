package com.example.repositories;

import com.example.models.Incident;
import org.springframework.data.mongodb.repository.MongoRepository;
// import org.springframework.stereotype.Repository;

// @Repository
public interface IncidentRepository extends MongoRepository<Incident, String> {
    // Additional custom methods can be added if needed
}
