package com.scottfarsace.spring.npcgenerator.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.scottfarsace.spring.npcgenerator.models.Archetype;
import com.scottfarsace.spring.npcgenerator.models.Goal;

import com.scottfarsace.spring.npcgenerator.repositories.GoalRepository;

@Service
public class GoalService {
    
    @Autowired
    GoalRepository nameRepo;

    // Single return values; gets a random match

    // Easier to use wrapper that accepts true objects
    // Selects based on both attributes
    public Optional<Goal> findGoal(Archetype archetype, double CR)
    {
        return nameRepo.findGoal(archetype.getId(), CR - 2.0, CR + 1.0);
    }

    // Direct wrapper over the underlying request
    public Optional<Goal> findGoal(Long archetypeId, double CR)
    {
        return nameRepo.findGoal(archetypeId, CR - 2.0, CR + 1.0);
    }

    // Easier to use wrapper that accepts true objects
    // Selects based on just archetype attribute
    public Optional<Goal> findGoal(Archetype archetype)
    {
        return nameRepo.findGoal(archetype.getId());
    }

    // Direct wrapper over the underlying request
    public Optional<Goal> findGoal(Long archetypeId)
    {
        return nameRepo.findGoal(archetypeId);
    }

    // Multiple return values; gets all matches

    // Easier to use wrapper that accepts true objects
    // Selects based on both attributes
    public List<Goal> findGoals(Archetype archetype, double CR)
    {
        return nameRepo.findGoals(archetype.getId(), CR - 2.0, CR + 1.0);
    }

    // Direct wrapper over the underlying request
    public List<Goal> findGoals(Long archetypeId, double CR)
    {
        return nameRepo.findGoals(archetypeId, CR - 2.0, CR + 1.0);
    }

    // Easier to use wrapper that accepts true objects
    // Selects based on just archetype attribute
    public List<Goal> findGoals(Archetype archetype)
    {
        return nameRepo.findGoals(archetype.getId());
    }

    // Direct wrapper over the underlying request
    public List<Goal> findGoals(Long archetypeId)
    {
        return nameRepo.findGoals(archetypeId);
    }
}
