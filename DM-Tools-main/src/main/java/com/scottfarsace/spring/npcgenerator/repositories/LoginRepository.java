/**
* Read/write login database
* Represents user login details
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

import com.scottfarsace.spring.npcgenerator.models.User;

@Repository
public interface LoginRepository extends CrudRepository<User, Long> {

    // High performance query by email because there may be unbounded amounts of Users to return
    Optional<User> findByEmail(String email); // find any user with given email
}
