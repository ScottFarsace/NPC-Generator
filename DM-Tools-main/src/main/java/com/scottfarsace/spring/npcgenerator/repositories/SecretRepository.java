/**
* Read Only Secret database
* Used so that secrets can be extended easily
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

import com.scottfarsace.spring.npcgenerator.models.Secret;

@Repository
public interface SecretRepository extends CrudRepository<Secret, Long> {
    @Query("SELECT u FROM Secret u WHERE u.archetypeId = ?1 AND u.cr >= ?2 AND u.cr <= ?3")
    List<Secret> findSecrets(Long archetypeId, double minCR, double maxCR);

    // High performance custom native query because JPQL does not support LIMIT or ORDER BY RAND() but MySQL does
    @Query(nativeQuery = true, value = "SELECT * FROM Secrets u WHERE u.archetype_id = ?1 AND u.cr >= ?2 AND u.cr <= ?3 ORDER BY RAND() LIMIT 1")
    Optional<Secret> findSecret(Long archetypeId, double minCR, double maxCR);
}