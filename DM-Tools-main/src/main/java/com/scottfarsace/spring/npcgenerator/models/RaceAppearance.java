/**
* Read Only RaceAppearance class
* Represents the RaceAppearance a character can have
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
@Table(name = "RaceAppearances")
final public class RaceAppearance {

    // Synthetic key to provide uniqueness for each row
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // creates unique ID in MySQL
    private Long Id;

    // Selection key, different races have different Appearances
    // Required
    @NotNull()
    private Long raceId;

    // Return value, the Appearance associated with this race
    @NotNull()
    @NotEmpty()
    private String raceAppearance;

    public RaceAppearance()
    {}

    public Long getId()
    {
        return Id;
    }

    public String getRaceAppearance() {
        return raceAppearance;
    }
}
