package com.scottfarsace.spring.npcgenerator.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.scottfarsace.spring.npcgenerator.models.Archetype;

import com.scottfarsace.spring.npcgenerator.repositories.ArchetypeRepository;

@Service
public class ArchetypeService {
    
    @Autowired
    ArchetypeRepository archetypeRepo;

    public Optional<Archetype> findBySymbolName(String symbolName)
    {
            return archetypeRepo.findBySymbolName(symbolName);
    }

    public Optional<Archetype> findRandom()
    {
        return archetypeRepo.findRandom();
    }
}
