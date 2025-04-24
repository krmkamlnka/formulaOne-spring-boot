package org.example.driverservice.repository;

import org.example.driverservice.entity.Team;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("team-service")
public interface TeamServiceRepository {
    @GetMapping("/api/teams/{id}")
    Team getTeamById(@PathVariable("id") Long id);
}
