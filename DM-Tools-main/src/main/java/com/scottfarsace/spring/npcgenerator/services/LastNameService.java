package com.scottfarsace.spring.npcgenerator.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.scottfarsace.spring.npcgenerator.models.Archetype;
import com.scottfarsace.spring.npcgenerator.models.LastName;
import com.scottfarsace.spring.npcgenerator.models.Race;

import com.scottfarsace.spring.npcgenerator.repositories.LastNameRepository;

@Service
public class LastNameService {
    
    @Autowired
    LastNameRepository nameRepo;

    // Single return values; gets a random match

    // Easier to use wrapper that accepts true objects object
    // Selects on both attributes
    public Optional<LastName> findName(Race race, Archetype archetype)
    {
        return nameRepo.findName(race.getId(), archetype.getId());
    }

    // Direct wrapper over the underlying request
    public Optional<LastName> findName(Long raceId, Long archetypeId)
    {
        return nameRepo.findName(raceId, archetypeId);
    }

    // Easier to use wrapper that accepts true objects object
    // Selects on the required attribute
    public Optional<LastName> findName(Race race)
    {
        return nameRepo.findName(race.getId());
    }

    // Direct wrapper over the underlying request
    public Optional<LastName> findName(Long raceId)
    {
        return nameRepo.findName(raceId);
    }


    // Multiple return values; gets all matches

    // Easier to use wrapper that accepts true objects object
    // Selects on both attributes
    public List<LastName> findNames(Race race, Archetype archetype)
    {
        return nameRepo.findNames(race.getId(), archetype.getId());
    }

    // Direct wrapper over the underlying request
    public List<LastName> findNames(Long raceId, Long archetypeId)
    {
        return nameRepo.findNames(raceId, archetypeId);
    }

    // Easier to use wrapper that accepts true objects object
    // Selects on the required attribute
    public List<LastName> findNames(Race race)
    {
        return nameRepo.findNames(race.getId());
    }

    // Direct wrapper over the underlying request
    public List<LastName> findNames(Long raceId)
    {
        return nameRepo.findNames(raceId);
    }
}
