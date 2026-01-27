package com.restapi.rest.controller;

import com.restapi.rest.entity.HealthCheckLog;
import com.restapi.rest.service.HealthService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class HealthController {

    private final HealthService healthService;

    public HealthController(HealthService healthService) {
        this.healthService = healthService;
    }

    @GetMapping("/health")
    public ResponseEntity<HealthCheckLog> health() {
        return ResponseEntity.ok(healthService.check());
    }
}
