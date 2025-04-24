package org.example.driverservice.service;

import org.example.driverservice.entity.Driver;
import org.example.driverservice.entity.Team;
import org.example.driverservice.repository.DriverRepository;
import org.example.driverservice.repository.TeamServiceRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DriverService {
    private DriverRepository driverRepository;
    private TeamServiceRepository teamServiceRepository;
    public DriverService(DriverRepository driverRepository, TeamServiceRepository teamServiceRepository) {
        this.driverRepository = driverRepository;
        this.teamServiceRepository = teamServiceRepository;
    }
    public List<Driver> getAllDrivers() {
        return driverRepository.findAll();
    }

    public void register(Driver driver) {
        driverRepository.save(driver);
    }

    public Driver getDriverById(Long id) {
        return driverRepository.findById(id).orElse(null);
    }

    public List<Driver> getDriversByTeamId(Long teamId) {
        return driverRepository.findByTeamId(teamId);
    }

    public Team getTeamByDriverId(Long id) {
        Driver driver = driverRepository.findById(id).orElse(null);
        if(driver == null) return null;
        return teamServiceRepository.getTeamById(driver.getTeamId());
    }
}
