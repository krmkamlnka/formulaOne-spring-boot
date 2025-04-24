package org.example.raceservice.repository;

import org.example.raceservice.dto.Driver;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "driver-service")
public interface DriverServiceRepository {
    @GetMapping("/api/drivers/{id}")
    Driver getDriver(@PathVariable("id") Long id);
}
