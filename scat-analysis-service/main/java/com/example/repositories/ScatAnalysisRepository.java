package com.example.repositories;

import com.example.models.ScatAnalysis;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ScatAnalysisRepository extends MongoRepository<ScatAnalysis, String> {
    // You can define custom query methods here if needed
}
