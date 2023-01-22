/**
* Read Only RaceAppearance database
* Used so that RaceAppearances can be extended easily
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

import com.scottfarsace.spring.npcgenerator.models.RaceAppearance;

@Repository
public interface RaceAppearanceRepository extends CrudRepository<RaceAppearance, Long> {
    @Query("SELECT u FROM RaceAppearance u WHERE u.raceId = ?1")
    List<RaceAppearance> findRaceAppearances(Long RaceId);

    // High performance custom native query because JPQL does not support LIMIT or ORDER BY RAND() but MySQL does
    @Query(nativeQuery = true, value = "SELECT * FROM race_appearances u WHERE u.race_id = ?1 ORDER BY RAND() LIMIT 1")
    Optional<RaceAppearance> findRaceAppearance(Long RaceId);
}