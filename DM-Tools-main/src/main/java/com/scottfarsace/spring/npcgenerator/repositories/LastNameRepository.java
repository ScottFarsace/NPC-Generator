/**
* Read Only Last Name database
* Used so that names can be extended easily
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

import com.scottfarsace.spring.npcgenerator.models.LastName;

@Repository
public interface LastNameRepository extends CrudRepository<LastName, Long> {
    @Query("SELECT u FROM LastName u WHERE u.raceId = ?1 AND u.archetypeId = ?2")
    List<LastName> findNames(Long raceId, Long archetypeId);

    @Query("SELECT u FROM LastName u WHERE u.raceId = ?1")
    List<LastName> findNames(Long raceId);

    // High performance custom native query because JPQL does not support LIMIT or ORDER BY RAND() but MySQL does
    @Query(nativeQuery = true, value = "SELECT * FROM last_names u WHERE u.race_id = ?1 AND u.archetype_id = ?2 ORDER BY RAND() LIMIT 1")
    Optional<LastName> findName(Long raceId, Long archetypeId);

    // High performance custom native query because JPQL does not support LIMIT or ORDER BY RAND() but MySQL does
    @Query(nativeQuery = true, value = "SELECT * FROM last_names u WHERE u.race_id = ?1 ORDER BY RAND() LIMIT 1")
    Optional<LastName> findName(Long raceId);
}