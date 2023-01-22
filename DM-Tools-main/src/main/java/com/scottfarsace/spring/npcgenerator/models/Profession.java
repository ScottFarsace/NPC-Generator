/**
* Read Only profession class
* Represents a profession in the Race database
* Readonly as this db is readonly
* SymbolName is made of only Java valid symbols
* Other language display names are also provided
* @author  Scott
* @version 0.1
* @since   2023-01-15
* @status Done
*/

package com.scottfarsace.spring.npcgenerator.models;

import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.EnumType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "Professions")
final public class Profession {

    // Synthetic key to provide uniqueness for each row
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // creates unique ID in MySQL
    private Long Id;

    // Selection key, different archetypes have different jobs available to them
    // Required
    @NotNull()
    private Long archetypeId;

    // Selection key, different CR's have different jobs (a level 10 farmer doesn't make sense)
    // Required
    @NotNull()
    private double cr;

    // Selection key, different sexes may have different profession names
    // Optional
    @Enumerated(EnumType.STRING)
    private Sex sex;

    // Return key, the java compatible symbol name
    @NotNull()
    @NotEmpty()
    private String symbolName;

    // Return key, the English compatible name
    @NotNull()
    @NotEmpty()
    private String englishName;

    public Profession()
    {}

    public Long getId()
    {
        return Id;
    }

    public String getSymbolName()
    {
        return symbolName;
    }

    public String getEnglishName()
    {
        return englishName;
    }
}