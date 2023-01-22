/**
* Read Only ArchetypeAppearance class
* Represents the ArchetypeAppearance a character can have
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
@Table(name = "ArchetypeAppearances")
final public class ArchetypeAppearance {

    // Synthetic key to provide uniqueness for each row
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // creates unique ID in MySQL
    private Long Id;

    // Selection key, different archetypes have different appearances
    // Required
    @NotNull()
    private Long archetypeId;

    // Return value, the appearance associated with this archetype
    @NotNull()
    @NotEmpty()
    private String archetypeAppearance;

    public ArchetypeAppearance()
    {}

    public Long getId()
    {
        return Id;
    }

    public String getArchetypeAppearance() {
        return archetypeAppearance;
    }
}
