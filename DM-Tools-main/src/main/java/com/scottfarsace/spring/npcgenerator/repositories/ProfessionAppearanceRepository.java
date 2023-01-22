/**
* Read Only ProfessionAppearance database
* Used so that ProfessionAppearances can be extended easily
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

import com.scottfarsace.spring.npcgenerator.models.ProfessionAppearance;

@Repository
public interface ProfessionAppearanceRepository extends CrudRepository<ProfessionAppearance, Long> {
    @Query("SELECT u FROM ProfessionAppearance u WHERE u.professionId = ?1")
    List<ProfessionAppearance> findProfessionAppearances(Long ProfessionId);

    // High performance custom native query because JPQL does not support LIMIT or ORDER BY RAND() but MySQL does
    @Query(nativeQuery = true, value = "SELECT * FROM ProfessionAppearances u WHERE u.profession_id = ?1 ORDER BY RAND() LIMIT 1")
    Optional<ProfessionAppearance> findProfessionAppearance(Long ProfessionId);
}