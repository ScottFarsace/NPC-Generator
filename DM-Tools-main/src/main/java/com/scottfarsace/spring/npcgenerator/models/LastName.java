/**
* Read Only Name class
* Represents a name a character can have
* Readonly as this db is readonly
* @author  Scott
* @version 0.1
* @since   2023-01-15
* @status Done
*/

package com.scottfarsace.spring.npcgenerator.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "LastNames")
final public class LastName {
    
    // Synthetic key to provide uniqueness for each row
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // creates unique ID in MySQL
    private Long Id;

    // Selection key, different races have different names
    // Required
    @NotNull()
    private Long raceId;

    // Selection key, different archetypes may have different names
    // Optional
    private Long archetypeId;

    // Return value, the name associated with those details
    @NotNull()
    @NotEmpty()
    private String name;

    public LastName()
    {}

    public Long getId()
    {
        return Id;
    }

    public String getName() {
        return name;
    }
}
