package com.scottfarsace.spring.npcgenerator.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.scottfarsace.spring.npcgenerator.models.Archetype;
import com.scottfarsace.spring.npcgenerator.models.Background;
import com.scottfarsace.spring.npcgenerator.models.Profession;

import com.scottfarsace.spring.npcgenerator.repositories.BackgroundRepository;

@Service
public class BackgroundService {
    
    @Autowired
    BackgroundRepository nameRepo;

    // Single return values; gets a random match

    // Easier to use wrapper that accepts true objects
    // Selects based on both attributes
    public Optional<Background> findBackground(Archetype archetype, Profession profession)
    {
        return nameRepo.findBackground(archetype.getId(), profession.getId());
    }

    // Direct wrapper over the underlying request
    public Optional<Background> findBackground(Long archetypeId, Long professionId)
    {
        return nameRepo.findBackground(archetypeId, professionId);
    }

    // Easier to use wrapper that accepts true objects
    // Selects based on just Archetype
    public Optional<Background> findBackground(Archetype archetype)
    {
        return nameRepo.findBackground(archetype.getId());
    }

    // Direct wrapper over the underlying request
    public Optional<Background> findBackground(Long archetypeId)
    {
        return nameRepo.findBackground(archetypeId);
    }


    // Multiple return values; gets all matches

    // Easier to use wrapper that accepts true objects
    // Selects based on both attributes
    public List<Background> findBackgrounds(Archetype archetype, Profession profession)
    {
        return nameRepo.findBackgrounds(archetype.getId(), profession.getId());
    }

    // Direct wrapper over the underlying request
    public List<Background> findBackgrounds(Long archetypeId, Long professionId)
    {
        return nameRepo.findBackgrounds(archetypeId, professionId);
    }

    // Easier to use wrapper that accepts true objects
    // Selects based on just Archetype
    public List<Background> findBackgrounds(Archetype archetype)
    {
        return nameRepo.findBackgrounds(archetype.getId());
    }

    // Direct wrapper over the underlying request
    public List<Background> findBackgrounds(Long archetypeId)
    {
        return nameRepo.findBackgrounds(archetypeId);
    }
}
