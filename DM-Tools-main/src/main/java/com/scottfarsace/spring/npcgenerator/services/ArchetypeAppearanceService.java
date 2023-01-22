package com.scottfarsace.spring.npcgenerator.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.scottfarsace.spring.npcgenerator.models.Archetype;
import com.scottfarsace.spring.npcgenerator.models.ArchetypeAppearance;

import com.scottfarsace.spring.npcgenerator.repositories.ArchetypeAppearanceRepository;

@Service
public class ArchetypeAppearanceService {
    
    @Autowired
    ArchetypeAppearanceRepository nameRepo;

    // Single return values; gets a random match

    // Easier to use wrapper that accepts true objects
    // Selects based on both attributes
    public Optional<ArchetypeAppearance> findArchetypeAppearance(Archetype archetype)
    {
        return nameRepo.findArchetypeAppearance(archetype.getId());
    }

    // Direct wrapper over the underlying request
    public Optional<ArchetypeAppearance> findArchetypeAppearance(Long archetypeId)
    {
        return nameRepo.findArchetypeAppearance(archetypeId);
    }


    // Multiple return values; gets all matches

    // Easier to use wrapper that accepts true objects
    // Selects based on both attributes
    public List<ArchetypeAppearance> findArchetypeAppearances(Archetype archetype)
    {
        return nameRepo.findArchetypeAppearances(archetype.getId());
    }

    // Direct wrapper over the underlying request
    public List<ArchetypeAppearance> findArchetypeAppearances(Long archetypeId)
    {
        return nameRepo.findArchetypeAppearances(archetypeId);
    }
}
