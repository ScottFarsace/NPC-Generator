/**
* NPC
*
* An NPC is the main output of this applicatiopn
* They are created by the user, stored in DB, and can be edited in place
* BaseNPC is used to gather data to create this
*
* @author  Scott
* @version 0.1
* @since   2023-01-15
* @status Done
*/

package com.scottfarsace.spring.npcgenerator.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "NPCs")
public class NPC {

    // Synthetic key to provide uniqueness for each row
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // creates unique ID in MySQL
    private Long Id;

    @NotNull(message = "Enter NPC Name")
    @NotEmpty()
    @Size(min = 3, max = 255) 
    private String name;

    @NotNull(message = "Enter NPC Race")
    @NotEmpty()
    private String race;

    @NotNull(message = "Enter NPC Archetype")
    @NotEmpty()
    private String archetype;

    @NotNull(message = "Enter NPC Sex")
    @Enumerated(EnumType.STRING)
    private Sex sex;

    @NotNull(message = "Enter NPC Challenge Rating (power level, 1-20)")
    private double challengeRating;

    @NotNull(message = "Enter NPC Alignment(Lawful, Neutral Chaotic?)")
    @Enumerated(EnumType.STRING)
    private SocialAlignment socialAlignment;

    @NotNull(message = "Enter NPC Alignment(Good, Neutral Evil?)")
    @Enumerated(EnumType.STRING)
    private MoralAlignment moralAlignment;

    @NotNull(message = "Enter valid NPC Age")
    private Integer age;

    @NotNull(message = "Enter NPC Profession")
    @Size(min = 3, max = 255)
    private String profession;

    @NotNull(message = "Enter NPC Appearance")
    @Size(min = 3, max = 255)
    private String appearance;
    
    @NotNull(message = "Enter NPC Quirks")
    @Size(min = 3, max = 255)
    private String quirks;
    
    @NotNull(message = "Enter NPC Background")
    @Size(min = 3, max = 255)
    private String background;
    
    @NotNull(message = "Enter NPC Motivation")
    @Size(min = 3, max = 255)
    private String motivation;

    @Column(updatable = false)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date createdAt;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date updatedAt;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User creator;

    public NPC() {
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRace() {
        return race;
    }

    public void setRace(String race) {
        this.race = race;
    }

    public String getArchetype() {
        return archetype;
    }

    public void setArchetype(String archetype) {
        this.archetype = archetype;
    }

    public Sex getSex() {
        return sex;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }

    public double getChallengeRating() {
        return challengeRating;
    }

    public void setChallengeRating(double challengeRating) {
        this.challengeRating = challengeRating;
    }

    public SocialAlignment getSocialAlignment() {
        return socialAlignment;
    }

    public void setSocialAlignment(SocialAlignment socialAlignment) {
        this.socialAlignment = socialAlignment;
    }

    public MoralAlignment getMoralAlignment() {
        return moralAlignment;
    }

    public void setMoralAlignment(MoralAlignment moralAlignment) {
        this.moralAlignment = moralAlignment;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public String getAppearance() {
        return appearance;
    }

    public void setAppearance(String appearance) {
        this.appearance = appearance;
    }

    public String getQuirks() {
        return quirks;
    }

    public void setQuirks(String quirks) {
        this.quirks = quirks;
    }

    public String getBackground() {
        return background;
    }

    public void setBackground(String background) {
        this.background = background;
    }

    public String getMotivation() {
        return motivation;
    }

    public void setMotivation(String motivation) {
        this.motivation = motivation;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt() {
        this.createdAt = new Date();
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt() {
        this.updatedAt = new Date();
    }

    public User getCreator() {
        return creator;
    }

    public void setCreator(User creator) {
        this.creator = creator;
    }
}
