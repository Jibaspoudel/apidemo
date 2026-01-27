package com.restapi.rest.entity;

import jakarta.persistence.*;
import java.time.Instant;

@Entity
@Table(name = "health_check_log")
public class HealthCheckLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String status;

    @Column(nullable = false, length = 500)
    private String message;

    @Column(name = "checked_at", nullable = false)
    private Instant checkedAt;

    public HealthCheckLog() {}

    public HealthCheckLog(String status, String message, Instant checkedAt) {
        this.status = status;
        this.message = message;
        this.checkedAt = checkedAt;
    }

    public Long getId() { return id; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public String getMessage() { return message; }
    public void setMessage(String message) { this.message = message; }

    public Instant getCheckedAt() { return checkedAt; }
    public void setCheckedAt(Instant checkedAt) { this.checkedAt = checkedAt; }
}
