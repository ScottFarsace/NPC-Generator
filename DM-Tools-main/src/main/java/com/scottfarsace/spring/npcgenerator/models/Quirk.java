/**
* Read Only Quirk class
* Represents the quirk a character can have
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
@Table(name = "Quirks")
final public class Quirk {

    // Synthetic key to provide uniqueness for each row
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // creates unique ID in MySQL
    private Long Id;

    // Selection key, different archetypes have different quirks
    // Required
    @NotNull()
    private Long archetypeId;

    // Return value, the quirk associated with this type of character
    @NotNull()
    @NotEmpty()
    private String quirk;

    public Quirk()
    {}

    public Long getId()
    {
        return Id;
    }

    public String getQuirk() {
        return quirk;
    }
}
