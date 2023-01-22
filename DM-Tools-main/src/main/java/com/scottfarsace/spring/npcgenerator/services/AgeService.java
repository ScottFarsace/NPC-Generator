package com.scottfarsace.spring.npcgenerator.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.scottfarsace.spring.npcgenerator.models.Age;
import com.scottfarsace.spring.npcgenerator.models.Race;

import com.scottfarsace.spring.npcgenerator.repositories.AgeRepository;

@Service
public class AgeService {
    
    @Autowired
    AgeRepository ageRepo;

    // Easier to use wrapper that accepts a Race object
    public Optional<Age> findByRace(Race race)
    {
            return ageRepo.findByRaceId(race.getId());
    }

    // Direct wrapper over the underlying request
    public Optional<Age> findByRace(Long raceId)
    {
            return ageRepo.findByRaceId(raceId);
    }
}
