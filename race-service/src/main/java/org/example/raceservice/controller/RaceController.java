package org.example.raceservice.controller;

import org.example.raceservice.entity.Race;
import org.example.raceservice.entity.RaceResult;
import org.example.raceservice.dto.RaceResultData;
import org.example.raceservice.service.RaceService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/races")
public class RaceController {
    private RaceService raceService;
    public RaceController(RaceService raceService) {
        this.raceService = raceService;
    }

    @PostMapping("/register")
    public ResponseEntity<Race> registerRace(@RequestBody Race race) {
        Race savedRace = raceService.register(race);
        return ResponseEntity.ok(savedRace);
    }

    @GetMapping("/{raceId}")
    public ResponseEntity<RaceResultData> getRaceById(@PathVariable Long raceId) {
        RaceResultData race = raceService.getRaceById(raceId);
        return ResponseEntity.ok(race);
    }

    @PostMapping("/save/results")
    public ResponseEntity<RaceResult> saveResults(@RequestBody RaceResult raceResult) {
        RaceResult saved = raceService.saveResults(raceResult);
        return ResponseEntity.ok(saved);
    }


}
