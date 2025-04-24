package org.example.teamservice.controller;

import org.example.teamservice.entity.Team;
import org.example.teamservice.entity.TeamDTO;
import org.example.teamservice.service.TeamService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/teams")
public class TeamController {
    private final TeamService teamService;
    public TeamController(TeamService teamService) {
        this.teamService = teamService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Team>> getAllTeams() {
        List<Team> teams = teamService.getAllTeams();
        return ResponseEntity.ok(teams);
    }

    @PostMapping("/register")
    public ResponseEntity<Team> registerTeam(@RequestBody Team team) {
        teamService.registerTeam(team);
        return ResponseEntity.ok(team);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TeamDTO> getTeamById(@PathVariable Long id) {
        TeamDTO team = teamService.getTeamById(id);
        return ResponseEntity.ok(team);
    }
}
