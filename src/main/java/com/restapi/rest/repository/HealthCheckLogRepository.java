package com.restapi.rest.repository;

import com.restapi.rest.entity.HealthCheckLog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HealthCheckLogRepository extends JpaRepository<HealthCheckLog, Long> {
}
