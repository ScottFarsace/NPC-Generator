/**
* Read Only background class
* Represents the background a character can have
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
@Table(name = "Backgrounds")
final public class Background {

    // Synthetic key to provide uniqueness for each row
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // creates unique ID in MySQL
    private Long Id;

    // Selection key, different archetypes have different backgrounds
    // Required
    @NotNull()
    private Long archetypeId;

    // Selection key, different professions may have different backgrounds
    // Optional
    private Long professionId;

    // Return value, the background associated with this type of character
    @NotNull()
    @NotEmpty()
    private String background;

    public Background()
    {}

    public Long getId()
    {
        return Id;
    }

    public String getBackground() {
        return background;
    }
}
