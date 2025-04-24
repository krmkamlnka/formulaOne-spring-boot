package org.example.teamservice.service;

import org.example.teamservice.entity.Team;
import org.example.teamservice.entity.TeamDTO;
import org.example.teamservice.repository.DriverServiceRepository;
import org.example.teamservice.repository.TeamRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeamService {
    private final TeamRepository teamRepository;
    private final DriverServiceRepository driverServiceRepository;
    public TeamService(TeamRepository teamRepository, DriverServiceRepository driverServiceRepository) {
        this.teamRepository = teamRepository;
        this.driverServiceRepository = driverServiceRepository;
    }
    public List<Team> getAllTeams() {
        return teamRepository.findAll();
    }

    public void registerTeam(Team team) {
        teamRepository.save(team);
    }

    public TeamDTO getTeamById(Long id) {
        Team team = teamRepository.findById(id).orElse(null);
        TeamDTO teamDTO = new TeamDTO();
        teamDTO.setId(id);
        teamDTO.setTeamName(team.getTeamName());
        teamDTO.setCountry(team.getCountry());
        teamDTO.setDrivers(driverServiceRepository.getDriversByTeamId(id));
        return teamDTO;
    }


}
