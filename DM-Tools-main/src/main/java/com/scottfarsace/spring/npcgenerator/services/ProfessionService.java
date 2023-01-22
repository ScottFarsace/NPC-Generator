package com.scottfarsace.spring.npcgenerator.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.scottfarsace.spring.npcgenerator.models.Archetype;
import com.scottfarsace.spring.npcgenerator.models.Profession;
import com.scottfarsace.spring.npcgenerator.models.Sex;

import com.scottfarsace.spring.npcgenerator.repositories.ProfessionRepository;

@Service
public class ProfessionService {
    
    @Autowired
    ProfessionRepository nameRepo;

    // Single return values; gets a random match

    // Easier to use wrapper that accepts true objects
    // Selects based on all three attributes
    public Optional<Profession> findProfession(Archetype archetype, double CR, Sex sex)
    {
        return nameRepo.findProfession(archetype.getId(), CR - 2.0, CR + 1.0, sex.name());
    }

    // Direct wrapper over the underlying request
    public Optional<Profession> findProfession(Long archetypeId, double CR, String sex)
    {
        return nameRepo.findProfession(archetypeId, CR - 2.0, CR + 1.0, sex);
    }

    // Easier to use wrapper that accepts true objects
    // Selects based on both required attributes
    public Optional<Profession> findProfession(Archetype archetype, double CR)
    {
        return nameRepo.findProfession(archetype.getId(), CR - 2.0, CR + 1.0);
    }

    // Direct wrapper over the underlying request
    public Optional<Profession> findProfession(Long archetypeId, double CR)
    {
        return nameRepo.findProfession(archetypeId, CR - 2.0, CR + 1.0);
    }


    // Multiple return values; gets all matches

    // Easier to use wrapper that accepts true objects
    // Selects based on all three attributes
    public List<Profession> findProfessions(Archetype archetype, double CR, Sex sex)
    {
        return nameRepo.findProfessions(archetype.getId(), CR - 2.0, CR + 1.0, sex.name());
    }

    // Direct wrapper over the underlying request
    public List<Profession> findProfessions(Long archetypeId, double CR, String sex)
    {
        return nameRepo.findProfessions(archetypeId, CR - 2.0, CR + 1.0, sex);
    }

    // Easier to use wrapper that accepts true objects
    // Selects based on both required attributes
    public List<Profession> findProfessions(Archetype archetype, double CR)
    {
        return nameRepo.findProfessions(archetype.getId(), CR - 2.0, CR + 1.0);
    }

    // Direct wrapper over the underlying request
    public List<Profession> findProfessions(Long archetypeId, double CR)
    {
        return nameRepo.findProfessions(archetypeId, CR - 2.0, CR + 1.0);
    }
}
