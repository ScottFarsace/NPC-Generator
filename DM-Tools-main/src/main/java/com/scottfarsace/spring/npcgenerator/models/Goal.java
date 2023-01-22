/**
* Read Only Goal class
* Represents the Goal a character can have
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
@Table(name = "Goals")
final public class Goal {

    // Synthetic key to provide uniqueness for each row
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // creates unique ID in MySQL
    private Long Id;

    // Selection key, different archetypes have different goals
    // Required
    @NotNull()
    private Long archetypeId;

    // Selection key, different power levels may confer different goals
    // Optional
    private double cr;

    // Return value, the goal associated with this type of character
    @NotNull()
    @NotEmpty()
    private String Goal;

    public Goal()
    {}

    public Long getId()
    {
        return Id;
    }

    public String getGoal() {
        return Goal;
    }
}
