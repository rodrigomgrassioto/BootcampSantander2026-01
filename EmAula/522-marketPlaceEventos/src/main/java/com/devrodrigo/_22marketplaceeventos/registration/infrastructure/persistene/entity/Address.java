package com.devrodrigo._22marketplaceeventos.registration.infrastructure.persistene.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.Instant;
import java.util.UUID;

@Entity
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String street, postalCode, city, state;

    @CreationTimestamp
    @Column(updatable = false, nullable = false)
    private Instant createdOn;

    public Address() {

    }

    public Address(UUID id, String street, String postalCode, String city, String state, Instant createdOn) {
        this.id = id;
        this.street = street;
        this.postalCode = postalCode;
        this.city = city;
        this.state = state;
        this.createdOn = createdOn;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Instant getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Instant createdOn) {
        this.createdOn = createdOn;
    }

    public String toString(){
        return String.format("%s, %s, %s, %s", street, postalCode, city, state);
    }
}
