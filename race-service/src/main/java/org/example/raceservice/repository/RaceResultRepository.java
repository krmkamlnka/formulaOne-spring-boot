package org.example.raceservice.repository;

import org.example.raceservice.entity.RaceResult;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RaceResultRepository extends JpaRepository<RaceResult, Long> {
    List<RaceResult> getRaceResultByRaceId(Long raceId);
}
