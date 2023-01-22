/**
* Read only Quirk database
* Used so that quirks can be extended easily
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

import com.scottfarsace.spring.npcgenerator.models.Quirk;

@Repository
public interface QuirkRepository extends CrudRepository<Quirk, Long> {
    @Query("SELECT u FROM Quirk u WHERE u.archetypeId = ?1")
    List<Quirk> findQuirks(Long archetypeId);

    // High performance custom native query because JPQL does not support LIMIT or ORDER BY RAND() but MySQL does
    @Query(nativeQuery = true, value = "SELECT * FROM Quirks u WHERE u.archetype_id = ?1 ORDER BY RAND() LIMIT 1")
    Optional<Quirk> findQuirk(Long archetypeId);
}
