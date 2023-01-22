package com.scottfarsace.spring.npcgenerator.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.scottfarsace.spring.npcgenerator.models.Race;

import com.scottfarsace.spring.npcgenerator.repositories.RaceRepository;

@Service
public class RaceService {
    
    @Autowired
    RaceRepository raceRepo;

    public Optional<Race> findBySymbolName(String symbolName)
    {
        return raceRepo.findBySymbolName(symbolName);
    }

    public Optional<Race> findRandom()
    {
        return raceRepo.findRandom();
    }
}
