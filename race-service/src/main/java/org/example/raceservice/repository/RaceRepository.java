package org.example.raceservice.repository;


import org.example.raceservice.entity.Race;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RaceRepository extends JpaRepository<Race, Long> {
    Race getRaceById(Long id);
}
