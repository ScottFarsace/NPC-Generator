/**
* Read Only Background database
* Used so that Backgrounds can be extended easily
* @author  Scott
* @version 0.1
* @since   2023-01-15
* @status Done
*/

package com.scottfarsace.spring.npcgenerator.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.scottfarsace.spring.npcgenerator.models.Background;

@Repository
public interface BackgroundRepository extends CrudRepository<Background, Long> {
    @Query("SELECT u FROM Background u WHERE u.archetypeId = ?1")
    List<Background> findBackgrounds(Long archetypeId);

    @Query("SELECT u FROM Background u WHERE u.archetypeId = ?1 AND u.professionId = ?2")
    List<Background> findBackgrounds(Long archetypeId, Long professionId);

    // High performance custom native query because JPQL does not support LIMIT or ORDER BY RAND() but MySQL does
    @Query(nativeQuery = true, value = "SELECT * FROM Backgrounds u WHERE u.archetype_id = ?1 ORDER BY RAND() LIMIT 1")
    Optional<Background> findBackground(Long archetypeId);

    // High performance custom native query because JPQL does not support LIMIT or ORDER BY RAND() but MySQL does
    @Query(nativeQuery = true, value = "SELECT * FROM Backgrounds u WHERE u.archetype_id = ?1 AND u.professionId = ?2 ORDER BY RAND() LIMIT 1")
    Optional<Background> findBackground(Long archetypeId, Long professionId);
}