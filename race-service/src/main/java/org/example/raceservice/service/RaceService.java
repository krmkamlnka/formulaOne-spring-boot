package org.example.raceservice.service;

import org.example.raceservice.dto.Driver;
import org.example.raceservice.dto.RaceResultData;
import org.example.raceservice.dto.Results;
import org.example.raceservice.entity.*;
import org.example.raceservice.repository.DriverServiceRepository;
import org.example.raceservice.repository.RaceRepository;
import org.example.raceservice.repository.RaceResultRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RaceService {
    private RaceRepository raceRepository;
    private RaceResultRepository raceResultRepository;
    private DriverServiceRepository driverServiceRepository;

    public RaceService(RaceRepository raceRepository, RaceResultRepository raceResultRepository, DriverServiceRepository driverServiceRepository) {
        this.raceRepository = raceRepository;
        this.raceResultRepository = raceResultRepository;
        this.driverServiceRepository = driverServiceRepository;
    }

    public Race register(Race race) {
        return raceRepository.save(race);
    }

    public RaceResultData getRaceById(Long raceId) {
        Race race = raceRepository.getRaceById(raceId);
        if(race == null) return null;

        List<RaceResult> raceResults = raceResultRepository.getRaceResultByRaceId(raceId);
        List<Results> results = new ArrayList<>();

        for(RaceResult raceResult : raceResults) {
            Driver driver = driverServiceRepository.getDriver(raceResult.getDriverId());
            Results result = new Results();
            result.setFullName(driver.getFullName());
            result.setPosition(raceResult.getPosition());
            results.add(result);
        }
        return new RaceResultData(race, results);
    }

    public RaceResult saveResults(RaceResult raceResult) {
        return raceResultRepository.save(raceResult);
    }

}
