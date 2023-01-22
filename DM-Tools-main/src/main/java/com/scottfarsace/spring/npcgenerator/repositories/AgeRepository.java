/**
* Read Only age database
* Used so that ages can be extended easily
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

import com.scottfarsace.spring.npcgenerator.models.Age;

@Repository
public interface AgeRepository extends CrudRepository<Age, Long> {

    // High performance query by race because there may be unbounded amounts of races and ages to search through
    Optional<Age> findByRaceId(Long raceId);
}