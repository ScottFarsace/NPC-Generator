package com.scottfarsace.spring.npcgenerator.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.scottfarsace.spring.npcgenerator.models.FirstName;
import com.scottfarsace.spring.npcgenerator.models.Sex;
import com.scottfarsace.spring.npcgenerator.models.Race;
import com.scottfarsace.spring.npcgenerator.models.Archetype;

import com.scottfarsace.spring.npcgenerator.repositories.FirstNameRepository;

@Service
public class FirstNameService {
    
    @Autowired
    FirstNameRepository nameRepo;

    // Single return values; gets a random match

    // Easier to use wrapper that accepts true objects
    // Selects based on all three attributes
    public Optional<FirstName> findName(Sex sex, Race race, Archetype archetype)
    {
        return nameRepo.findName(sex.name(), race.getId(), archetype.getId());
    }

    // Direct wrapper over the underlying request
    public Optional<FirstName> findName(Sex sex, Long raceId, Long archetypeId)
    {
        return nameRepo.findName(sex.name(), raceId, archetypeId);
    }

    // Easier to use wrapper that accepts true objects object
    // Selects on two required attributes
    public Optional<FirstName> findName(Sex sex, Race race)
    {
        return nameRepo.findName(sex.name(), race.getId());
    }

    // Direct wrapper over the underlying request
    public Optional<FirstName> findName(Sex sex, Long raceId)
    {
        return nameRepo.findName(sex.name(), raceId);
    }

    // Multiple return values; gets all matches

    // Easier to use wrapper that accepts true objects
    // Selects based on all three attributes
    public List<FirstName> findNames(Sex sex, Race race, Archetype archetype)
    {
        return nameRepo.findNames(sex, race.getId(), archetype.getId());
    }

    // Direct wrapper over the underlying request
    public List<FirstName> findNames(Sex sex, Long raceId, Long archetypeId)
    {
        return nameRepo.findNames(sex, raceId, archetypeId);
    }

    // Easier to use wrapper that accepts true objects object
    // Selects on two required attributes
    public List<FirstName> findNames(Sex sex, Race race)
    {
        return nameRepo.findNames(sex, race.getId());
    }

    // Direct wrapper over the underlying request
    public List<FirstName> findNames(Sex sex, Long raceId)
    {
        return nameRepo.findNames(sex, raceId);
    }
}
