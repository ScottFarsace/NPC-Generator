package com.scottfarsace.spring.npcgenerator.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.scottfarsace.spring.npcgenerator.models.Profession;
import com.scottfarsace.spring.npcgenerator.models.ProfessionAppearance;

import com.scottfarsace.spring.npcgenerator.repositories.ProfessionAppearanceRepository;

@Service
public class ProfessionAppearanceService {
    
    @Autowired
    ProfessionAppearanceRepository nameRepo;

    // Single return values; gets a random match

    // Easier to use wrapper that accepts true objects
    // Selects based on both attributes
    public Optional<ProfessionAppearance> findProfessionAppearance(Profession Profession)
    {
        return nameRepo.findProfessionAppearance(Profession.getId());
    }

    // Direct wrapper over the underlying request
    public Optional<ProfessionAppearance> findProfessionAppearance(Long ProfessionId)
    {
        return nameRepo.findProfessionAppearance(ProfessionId);
    }


    // Multiple return values; gets all matches

    // Easier to use wrapper that accepts true objects
    // Selects based on both attributes
    public List<ProfessionAppearance> findProfessionAppearances(Profession Profession)
    {
        return nameRepo.findProfessionAppearances(Profession.getId());
    }

    // Direct wrapper over the underlying request
    public List<ProfessionAppearance> findProfessionAppearances(Long ProfessionId)
    {
        return nameRepo.findProfessionAppearances(ProfessionId);
    }
}
