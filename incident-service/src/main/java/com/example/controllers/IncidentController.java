package com.example.controllers;

import com.example.models.Incident;
import com.example.repositories.IncidentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/incidents")
public class IncidentController {
    @Autowired
    private IncidentRepository incidentRepository;

    @GetMapping
    public List<Incident> getAllIncidents() {
        return incidentRepository.findAll();
    }

    @GetMapping("/{id}")
    public Incident getIncidentById(@PathVariable String id) {
        Optional<Incident> incidentOptional = incidentRepository.findById(id);
        return incidentOptional.orElse(null);
    }

    @PostMapping
    public Incident createIncident(@RequestBody Incident incident) {
        return incidentRepository.save(incident);
    }

    @PutMapping("/{id}")
    public Incident updateIncident(@PathVariable String id, @RequestBody Incident updatedIncident) {
        Optional<Incident> incidentOptional = incidentRepository.findById(id);
        if (incidentOptional.isPresent()) {
            Incident existingIncident = incidentOptional.get();
            existingIncident.setName(updatedIncident.getName());
            existingIncident.setDate(updatedIncident.getDate());
            existingIncident.setLocation(updatedIncident.getLocation());
            existingIncident.setSummary(updatedIncident.getSummary());
            existingIncident.setImmediateActions(updatedIncident.getImmediateActions());
            existingIncident.setIncidentType(updatedIncident.getIncidentType());
            existingIncident.setIncidentClassification(updatedIncident.getIncidentClassification());
            existingIncident.setImmediateCauses(updatedIncident.getImmediateCauses());
            existingIncident.setBasicCauses(updatedIncident.getBasicCauses());
            return incidentRepository.save(existingIncident);
        } else {
            return null; // or throw an exception, handle the case when the record does not exist
        }
    }

    @DeleteMapping("/{id}")
    public void deleteIncident(@PathVariable String id) {
        incidentRepository.deleteById(id);
    }
}
