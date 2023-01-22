/**
* Read Only profession database
* Used so that professions can be extended easily
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

import com.scottfarsace.spring.npcgenerator.models.Profession;

@Repository
public interface ProfessionRepository extends CrudRepository<Profession, Long> {
    @Query("SELECT u FROM Profession u WHERE u.archetypeId = ?1 AND u.cr >= ?2 AND u.cr <= ?3 AND u.sex = ?4")
    List<Profession> findProfessions(Long archetypeId, double minCR, double maxCR, String sex);

    @Query("SELECT u FROM Profession u WHERE u.archetypeId = ?1 AND u.cr >= ?2 AND u.cr <= ?3")
    List<Profession> findProfessions(Long archetypeId, double minCR, double maxCR);

    // High performance custom native query because JPQL does not support LIMIT or ORDER BY RAND() but MySQL does
    @Query(nativeQuery = true, value = "SELECT * FROM professions u WHERE u.archetype_id = ?1 AND u.cr >= ?2 AND u.cr <= ?3 AND u.sex = ?4 ORDER BY RAND() LIMIT 1")
    Optional<Profession> findProfession(Long archetypeId, double minCR, double maxCR, String sex);

    // High performance custom native query because JPQL does not support LIMIT or ORDER BY RAND() but MySQL does
    @Query(nativeQuery = true, value = "SELECT * FROM professions u WHERE u.archetype_id = ?1 AND u.cr >= ?2 AND u.cr <= ?3 ORDER BY RAND() LIMIT 1")
    Optional<Profession> findProfession(Long archetypeId, double minCR, double maxCR);
}