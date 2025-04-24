package org.example.teamservice.repository;

import org.example.teamservice.entity.Driver;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.cloud.openfeign.FeignClient;

import java.util.List;

@FeignClient(name="driver-service")
public interface DriverServiceRepository {
    @GetMapping("/api/drivers/team/{teamId}")
    List<Driver> getDriversByTeamId(@PathVariable Long teamId);
}
