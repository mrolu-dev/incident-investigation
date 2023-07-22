package com.example.controllers;

import com.example.models.ScatAnalysis;
import com.example.repositories.ScatAnalysisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/scat-analysis")
public class ScatAnalysisController {
    @Autowired
    private ScatAnalysisRepository scatAnalysisRepository;

    @GetMapping
    public List<ScatAnalysis> getAllScatAnalysis() {
        return scatAnalysisRepository.findAll();
    }

    @GetMapping("/{id}")
    public ScatAnalysis getScatAnalysisById(@PathVariable String id) {
        Optional<ScatAnalysis> scatAnalysisOptional = scatAnalysisRepository.findById(id);
        return scatAnalysisOptional.orElse(null);
    }

    @PostMapping
    public ScatAnalysis createScatAnalysis(@RequestBody ScatAnalysis scatAnalysis) {
        return scatAnalysisRepository.save(scatAnalysis);
    }

    @PutMapping("/{id}")
    public ScatAnalysis updateScatAnalysis(@PathVariable String id, @RequestBody ScatAnalysis updatedScatAnalysis) {
        Optional<ScatAnalysis> scatAnalysisOptional = scatAnalysisRepository.findById(id);
        if (scatAnalysisOptional.isPresent()) {
            ScatAnalysis existingScatAnalysis = scatAnalysisOptional.get();
            existingScatAnalysis.setIncidentId(updatedScatAnalysis.getIncidentId());
            existingScatAnalysis.setRootCause(updatedScatAnalysis.getRootCause());
            return scatAnalysisRepository.save(existingScatAnalysis);
        } else {
            return null; // or throw an exception, handle the case when the record does not exist
        }
    }

    @DeleteMapping("/{id}")
    public void deleteScatAnalysis(@PathVariable String id) {
        scatAnalysisRepository.deleteById(id);
    }
}
