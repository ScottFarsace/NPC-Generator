/**
* Read Only archetype database
* Used so that archetypes can be extended easily
* @author  Scott
* @version 0.1
* @since   2023-01-15
* @status Done
*/

package com.scottfarsace.spring.npcgenerator.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.scottfarsace.spring.npcgenerator.models.Archetype;

@Repository
public interface ArchetypeRepository extends CrudRepository<Archetype, Long> {

    // High performance query from Symbol Name because there may be unbounded amounts of archetypes to return
    // We also need a mapping from symbol name to a human readable name, because Java is more strict than natural languages
    Optional<Archetype> findBySymbolName(String symbolName);

    // High performance custom native query because JPQL does not support LIMIT or ORDER BY RAND() but MySQL does
    @Query(nativeQuery = true, value = "SELECT * FROM Archetypes u ORDER BY RAND() LIMIT 1")
    Optional<Archetype> findRandom();
}