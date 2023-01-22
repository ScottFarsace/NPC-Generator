/**
* Read Only Secret class
* Represents the Secret a character can have
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
@Table(name = "Secrets")
final public class Secret {

    // Synthetic key to provide uniqueness for each row
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // creates unique ID in MySQL
    private Long Id;

    // Selection key, different archetypes have different Secrets
    // Required
    @NotNull()
    private Long archetypeId;

    // Selection key, different power levels may confer different goals
    // Optional
    private double cr;

    // Return value, the Secret associated with this type of character
    @NotNull()
    @NotEmpty()
    private String Secret;

    public Secret()
    {}

    public Long getId()
    {
        return Id;
    }

    public String getSecret() {
        return Secret;
    }
}
