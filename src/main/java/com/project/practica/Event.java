package com.project.practica;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.Data;
import java.time.LocalDateTime;

@Data
@Document(collection = "events")
public class Event {
    @Id
    private String id;
    private String name;
    private String tournament;
    private String location;
    private LocalDateTime startTime;
    private String home;
    private String away;

    public String getName() {
        return name;
    }

    public String getTournament() {
        return tournament;
    }

    public String getLocation() {
        return location;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public String getHome() {
        return home;
    }

    public String getAway() {
        return away;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTournament(String tournament) {
        this.tournament = tournament;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public void setHome(String home) {
        this.home = home;
    }

    public void setAway(String away) {
        this.away = away;
    }
}

