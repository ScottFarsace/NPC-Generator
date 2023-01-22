package com.scottfarsace.spring.npcgenerator.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.scottfarsace.spring.npcgenerator.models.NPC;
import com.scottfarsace.spring.npcgenerator.models.User;

import com.scottfarsace.spring.npcgenerator.repositories.NPCRepository;

@Service
public class NPCService {
    
    @Autowired
    NPCRepository npcRepo;
    
    public NPC createNpc(NPC newNPC) {
        return npcRepo.save(newNPC);
    }

    public NPC getOneNPC(Long id) {
        return npcRepo.findById(id).get();
    }
    
    public NPC updateNPC(NPC updateNPC) {
        return npcRepo.save(updateNPC);
    }
    
    public void deleteNPC(Long id) {
        npcRepo.deleteById(id);
    }
    
    public List<NPC> findByUser(User user) {
        return npcRepo.findByCreator(user);
    }

    public List<NPC> findByCreatorSortedNameAscending(User user) {
        return npcRepo.findByCreatorSortedNameAscending(user.getId());
    }

    public List<NPC> findByCreatorSortedNameDescending(User user) {
        return npcRepo.findByCreatorSortedNameDescending(user.getId());
    }
    
    public List<NPC> findByCreatorSortedRaceAscending(User user) {
        return npcRepo.findByCreatorSortedRaceAscending(user.getId());
    }

    public List<NPC> findByCreatorSortedRaceDescending(User user) {
        return npcRepo.findByCreatorSortedRaceDescending(user.getId());
    }
    
    public List<NPC> findByCreatorSortedCrAscending(User user) {
        return npcRepo.findByCreatorSortedCrAscending(user.getId());
    }

    public List<NPC> findByCreatorSortedCrDescending(User user) {
        return npcRepo.findByCreatorSortedCrDescending(user.getId());
    }
    
    
}
