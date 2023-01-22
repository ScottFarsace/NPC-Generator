package com.scottfarsace.spring.npcgenerator.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.scottfarsace.spring.npcgenerator.models.Archetype;
import com.scottfarsace.spring.npcgenerator.models.Secret;

import com.scottfarsace.spring.npcgenerator.repositories.SecretRepository;

@Service
public class SecretService {
    
    @Autowired
    SecretRepository nameRepo;

    // Single return values; gets a random match

    // Easier to use wrapper that accepts true objects
    // Selects based on both attributes
    public Optional<Secret> findSecret(Archetype archetype, double CR)
    {
        return nameRepo.findSecret(archetype.getId(), CR - 2.0, CR + 1.0);
    }

    // Direct wrapper over the underlying request
    public Optional<Secret> findSecret(Long archetypeId, double CR)
    {
        return nameRepo.findSecret(archetypeId, CR - 2.0, CR + 1.0);
    }


    // Multiple return values; gets all matches

    // Easier to use wrapper that accepts true objects
    // Selects based on both attributes
    public List<Secret> findSecrets(Archetype archetype, double CR)
    {
        return nameRepo.findSecrets(archetype.getId(), CR - 2.0, CR + 1.0);
    }

    // Direct wrapper over the underlying request
    public List<Secret> findSecrets(Long archetypeId, double CR)
    {
        return nameRepo.findSecrets(archetypeId, CR - 2.0, CR + 1.0);
    }
}
