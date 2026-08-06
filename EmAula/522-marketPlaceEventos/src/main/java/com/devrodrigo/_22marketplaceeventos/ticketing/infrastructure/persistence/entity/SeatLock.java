package com.devrodrigo._22marketplaceeventos.ticketing.infrastructure.persistence.entity;

import jakarta.persistence.Id;
import jakarta.persistence.Index;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.index.Indexed;

import java.time.Instant;

@RedisHash(value = "seat_lock", timeToLive = 60)
public class SeatLock {
    @Id
    private String id;

    @Indexed
    private String customerId;

    private Instant createdAt;

    public SeatLock() {
    }

    public SeatLock(String id, String customerId, Instant createdAt) {
        this.id = id;
        this.customerId = customerId;
        this.createdAt = createdAt;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Instant createdAt) {
        this.createdAt = createdAt;
    }
}
