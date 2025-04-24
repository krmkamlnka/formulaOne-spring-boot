package org.example.driverservice.controller;

import org.example.driverservice.entity.Driver;
import org.example.driverservice.entity.Team;
import org.example.driverservice.service.DriverService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/drivers")
public class DriverController {
    private final DriverService driverService;
    public DriverController(DriverService driverService) {
        this.driverService = driverService;
    }
    //•	GET /drivers/{id} – информация о гонщике

    @GetMapping("/all")
    public ResponseEntity<List<Driver>> getDrivers() {
        List<Driver> drivers = driverService.getAllDrivers();
        return ResponseEntity.ok().body(drivers);
    }

    @PostMapping("/register")
    public ResponseEntity<Driver> registerDriver(@RequestBody Driver driver) {
        driverService.register(driver);
        return ResponseEntity.ok().body(driver);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Driver> getDriver(@PathVariable Long id){
        Driver driver = driverService.getDriverById(id);
        return ResponseEntity.ok().body(driver);
    }

    @GetMapping("/team/{teamId}")
    public ResponseEntity<List<Driver>> getDriversByTeamId(@PathVariable Long teamId) {
        List<Driver> drivers = driverService.getDriversByTeamId(teamId);
        return ResponseEntity.ok().body(drivers);
    }

    @GetMapping("/{driverId}/team")
    public ResponseEntity<Team> getTeamByDriverId(@PathVariable Long driverId) {
        Team team = driverService.getTeamByDriverId(driverId);
        return ResponseEntity.ok().body(team);
    }

}
