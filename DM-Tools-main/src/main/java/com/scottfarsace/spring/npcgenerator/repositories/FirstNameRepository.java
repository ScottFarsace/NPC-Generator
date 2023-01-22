/**
* Read Only First Name database
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

import com.scottfarsace.spring.npcgenerator.models.FirstName;
import com.scottfarsace.spring.npcgenerator.models.Sex;

@Repository
public interface FirstNameRepository extends CrudRepository<FirstName, Long> {

    @Query("SELECT u FROM FirstName u WHERE u.sex = ?1 AND u.raceId = ?2 AND u.archetypeId = ?3")
    List<FirstName> findNames(Sex sex, Long raceId, Long archetypeId);

    @Query("SELECT u FROM FirstName u WHERE u.sex = ?1 AND u.raceId = ?2")
    List<FirstName> findNames(Sex sex, Long raceId);

    // High performance custom native query because JPQL does not support LIMIT or ORDER BY RAND() but MySQL does
    @Query(nativeQuery = true, value = "SELECT * FROM first_names u WHERE u.sex = ?1 AND u.race_id = ?2 AND u.archetype_id = ?3 ORDER BY RAND() LIMIT 1")
    Optional<FirstName> findName(String sex, Long raceId, Long archetypeId);

    // High performance custom native query because JPQL does not support LIMIT or ORDER BY RAND() but MySQL does
    @Query(nativeQuery = true, value = "SELECT * FROM first_names u WHERE u.sex = ?1 AND u.race_id = ?2 ORDER BY RAND() LIMIT 1")
    Optional<FirstName> findName(String sex, Long raceId);
}