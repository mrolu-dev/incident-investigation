package com.example.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "incidents")
public class Incident {
    @Id
    private String id;
    private String name;
    private String date;
    private String location;
    private String summary;
    private String immediateActions;
    private String incidentType;
    private String incidentClassification;
    private String immediateCauses;
    private String basicCauses;

    // Getters and setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getImmediateActions() {
        return immediateActions;
    }

    public void setImmediateActions(String immediateActions) {
        this.immediateActions = immediateActions;
    }

    public String getIncidentType() {
        return incidentType;
    }

    public void setIncidentType(String incidentType) {
        this.incidentType = incidentType;
    }

    public String getIncidentClassification() {
        return incidentClassification;
    }

    public void setIncidentClassification(String incidentClassification) {
        this.incidentClassification = incidentClassification;
    }

    public String getImmediateCauses() {
        return immediateCauses;
    }

    public void setImmediateCauses(String immediateCauses) {
        this.immediateCauses = immediateCauses;
    }

    public String getBasicCauses() {
        return basicCauses;
    }

    public void setBasicCauses(String basicCauses) {
        this.basicCauses = basicCauses;
    }
}
