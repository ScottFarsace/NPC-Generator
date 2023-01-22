/**
* Read Only Age class
* Represents the ages a race can have
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

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "Ages")
final public class Age {

    // Synthetic key to provide uniqueness for each row
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // creates unique ID in MySQL
    private Long Id;

    // Selection key, as different races have different age ranges
    // Required
    @NotNull()
    private Long raceId;

    // Return value, the time needed to mature to an adult
    @NotNull()
    @Size(min = 0, max = 100) //
    private long maturation;

    // Return value, the max life span of this race
    @NotNull()
    @Size(min = 65, max = 800) //
    private long lifespan;

    public Age()
    {}

    public Long getId() {
        return Id;
    }

    public Long getRaceId() {
        return raceId;
    }

    public long  getMaturationAge() {
        return maturation;
    }

    public long getLifespan() {
        return lifespan;
    }
}
