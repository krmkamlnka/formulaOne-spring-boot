package org.example.raceservice.dto;

import lombok.Getter;
import lombok.Setter;
import org.example.raceservice.entity.Race;

import java.util.List;

@Setter
@Getter
public class RaceResultData {
    private Long id;
    private String place;
    private String date;
    private List<Results> results;

    public RaceResultData(Race race, List<Results> results) {
        id = race.getId();
        place = race.getPlace();
        date = race.getDate();
        this.results = results;
    }

}
