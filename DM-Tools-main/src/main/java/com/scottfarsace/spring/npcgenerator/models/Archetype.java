/**
* Read Only Archetype class
* Represents possible archetypes a character can have
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
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "Archetypes")
final public class Archetype {

    // Synthetic key to provide uniqueness for each row
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // creates unique ID in MySQL
    private Long Id;

    // Selection key, the Java compatible name
    // Distinct
    @Column(unique=true)
    @NotNull()
    @NotEmpty()
    private String symbolName;

    // Return key, the English compatible name
    @NotNull()
    @NotEmpty()
    private String englishName;

    public Archetype()
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
