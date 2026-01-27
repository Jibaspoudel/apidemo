package com.restapi.rest.service.impl;

import com.restapi.rest.entity.HealthCheckLog;
import com.restapi.rest.repository.HealthCheckLogRepository;
import com.restapi.rest.service.HealthService;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
public class HealthServiceImpl implements HealthService {

    private final HealthCheckLogRepository healthCheckLogRepository;

    public HealthServiceImpl(HealthCheckLogRepository healthCheckLogRepository) {
        this.healthCheckLogRepository = healthCheckLogRepository;
    }

    @Override
    public HealthCheckLog check() {
        // Business logic lives here: decide the health status + what to persist.
        String status = "UP";
        String message = "Service is healthy";
        Instant now = Instant.now();

        // Persist log entry (controller never talks to DB directly)
        return healthCheckLogRepository.save(new HealthCheckLog(status, message, now));
    }
}
