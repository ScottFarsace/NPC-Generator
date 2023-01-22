/**
* Read/write NPC database
* Represents NPC's that Users have created
* @author  Scott
* @version 0.1
* @since   2023-01-15
* @status Done
*/

package com.scottfarsace.spring.npcgenerator.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.scottfarsace.spring.npcgenerator.models.NPC;
import com.scottfarsace.spring.npcgenerator.models.User;

@Repository
public interface NPCRepository extends CrudRepository<NPC, Long> {

    List<NPC> findByCreator(User creator);

    // High performance custom native query because JPQL does not support LIMIT or ORDER BY RAND() but MySQL does
    @Query(nativeQuery = true, value = "SELECT * FROM npcs u WHERE u.user_id = ?1 ORDER BY name ASC")
    List<NPC> findByCreatorSortedNameAscending(Long userId);

    // High performance custom native query because JPQL does not support LIMIT or ORDER BY RAND() but MySQL does
    @Query(nativeQuery = true, value = "SELECT * FROM npcs u WHERE u.user_id = ?1 ORDER BY name DESC")
    List<NPC> findByCreatorSortedNameDescending(Long userId);
    
    // High performance custom native query because JPQL does not support LIMIT or ORDER BY RAND() but MySQL does
    @Query(nativeQuery = true, value = "SELECT * FROM npcs u WHERE u.user_id = ?1 ORDER BY race ASC")
    List<NPC> findByCreatorSortedRaceAscending(Long userId);

    // High performance custom native query because JPQL does not support LIMIT or ORDER BY RAND() but MySQL does
    @Query(nativeQuery = true, value = "SELECT * FROM npcs u WHERE u.user_id = ?1 ORDER BY race DESC")
    List<NPC> findByCreatorSortedRaceDescending(Long userId);
    
    // High performance custom native query because JPQL does not support LIMIT or ORDER BY RAND() but MySQL does
    @Query(nativeQuery = true, value = "SELECT * FROM npcs u WHERE u.user_id = ?1 ORDER BY challenge_rating ASC")
    List<NPC> findByCreatorSortedCrAscending(Long userId);

    // High performance custom native query because JPQL does not support LIMIT or ORDER BY RAND() but MySQL does
    @Query(nativeQuery = true, value = "SELECT * FROM npcs u WHERE u.user_id = ?1 ORDER BY challenge_rating DESC")
    List<NPC> findByCreatorSortedCrDescending(Long userId);
    
}
