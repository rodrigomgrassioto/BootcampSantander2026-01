package com.devrodrigo._22marketplaceeventos.catalog.infrastructure.persistence.entity;

import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Document
public class EventMetadata {
    @Id
    private String id;

    @NotNull
    private UUID eventId;

    private String eventDescription;
    private Map<String, Object> technicalRequirements;
    private List<Sector>sectors;
    private List<Seat> seats;

    @CreatedDate
    private Instant createdOn;

    public EventMetadata() {
    }

    public EventMetadata
            (String id, UUID eventId, String eventDescription, Map<String, Object> technicalRequirements,
             List<Sector> sectors, List<Seat> seats, Instant createdOn) {
        this.id = id;
        this.eventId = eventId;
        this.eventDescription = eventDescription;
        this.technicalRequirements = technicalRequirements;
        this.sectors = sectors;
        this.seats = seats;
        this.createdOn = createdOn;
    }

    public static class Sector {
        private String name;
        private BigDecimal price;

        public Sector() {
        }

        public Sector(String name, BigDecimal price) {
            this.name = name;
            this.price = price;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public BigDecimal getPrice() {
            return price;
        }

        public void setPrice(BigDecimal price) {
            this.price = price;
        }
    }

    public static class Seat {
        private String code;
        private String sectorName;

        public Seat() {
        }

        public Seat(String code, String sectorName) {
            this.code = code;
            this.sectorName = sectorName;
        }

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }

        public String getSectorName() {
            return sectorName;
        }

        public void setSectorName(String sectorName) {
            this.sectorName = sectorName;
        }
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public UUID getEventId() {
        return eventId;
    }

    public void setEventId(UUID eventId) {
        this.eventId = eventId;
    }

    public String getEventDescription() {
        return eventDescription;
    }

    public void setEventDescription(String eventDescription) {
        this.eventDescription = eventDescription;
    }

    public Map<String, Object> getTechnicalRequirements() {
        return technicalRequirements;
    }

    public void setTechnicalRequirements(Map<String, Object> technicalRequirements) {
        this.technicalRequirements = technicalRequirements;
    }

    public List<Sector> getSectors() {
        return sectors;
    }

    public void setSectors(List<Sector> sectors) {
        this.sectors = sectors;
    }

    public List<Seat> getSeats() {
        return seats;
    }

    public void setSeats(List<Seat> seats) {
        this.seats = seats;
    }

    public Instant getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Instant createdOn) {
        this.createdOn = createdOn;
    }
}
