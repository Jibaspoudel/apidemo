package com.restapi.rest.service;

import com.restapi.rest.entity.HealthCheckLog;

public interface HealthService {
    /**
     * Runs a health check and persists the result.
     *
     * This project variant intentionally returns the persisted Entity directly
     * (no DTO layer).
     */
    HealthCheckLog check();
}
