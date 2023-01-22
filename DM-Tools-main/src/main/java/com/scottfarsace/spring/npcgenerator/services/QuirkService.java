package com.scottfarsace.spring.npcgenerator.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.scottfarsace.spring.npcgenerator.models.Archetype;
import com.scottfarsace.spring.npcgenerator.models.Quirk;

import com.scottfarsace.spring.npcgenerator.repositories.QuirkRepository;

@Service
public class QuirkService {
    
    @Autowired
    QuirkRepository nameRepo;

    // Single return values; gets a random match

    // Easier to use wrapper that accepts true objects
    public Optional<Quirk> findQuirk(Archetype archetype)
    {
        return nameRepo.findQuirk(archetype.getId());
    }

    // Direct wrapper over the underlying request
    public Optional<Quirk> findQuirk(Long archetypeId)
    {
        return nameRepo.findQuirk(archetypeId);
    }


    // Multiple return values; gets all matches

    // Easier to use wrapper that accepts true objects
    public List<Quirk> findQuirks(Archetype archetype)
    {
        return nameRepo.findQuirks(archetype.getId());
    }

    // Direct wrapper over the underlying request
    public List<Quirk> findQuirks(Long archetypeId)
    {
        return nameRepo.findQuirks(archetypeId);
    }
}
