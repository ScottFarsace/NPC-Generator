package com.scottfarsace.spring.npcgenerator.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.scottfarsace.spring.npcgenerator.models.Race;
import com.scottfarsace.spring.npcgenerator.models.RaceAppearance;

import com.scottfarsace.spring.npcgenerator.repositories.RaceAppearanceRepository;

@Service
public class RaceAppearanceService {
    
    @Autowired
    RaceAppearanceRepository nameRepo;

    // Single return values; gets a random match

    // Easier to use wrapper that accepts true objects
    // Selects based on both attributes
    public Optional<RaceAppearance> findRaceAppearance(Race Race)
    {
        return nameRepo.findRaceAppearance(Race.getId());
    }

    // Direct wrapper over the underlying request
    public Optional<RaceAppearance> findRaceAppearance(Long RaceId)
    {
        return nameRepo.findRaceAppearance(RaceId);
    }


    // Multiple return values; gets all matches

    // Easier to use wrapper that accepts true objects
    // Selects based on both attributes
    public List<RaceAppearance> findRaceAppearances(Race Race)
    {
        return nameRepo.findRaceAppearances(Race.getId());
    }

    // Direct wrapper over the underlying request
    public List<RaceAppearance> findRaceAppearances(Long RaceId)
    {
        return nameRepo.findRaceAppearances(RaceId);
    }
}
