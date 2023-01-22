/**
* BasicNPC 
* 
* Used to marshal data between two web pages
* Does not go into a database
* @author  Scott
* @version 0.1
* @since   2023-01-15
* @status Done
*/

package com.scottfarsace.spring.npcgenerator.models;

import java.util.Date;

public class BasicNPC {

    private String name;
    private String race;
    private String archetype;
    private Sex sex;

    private double challengeRating;

    private SocialAlignment socialAlignment;
    private MoralAlignment moralAlignment;

    private int age;

    private String profession;
    private String appearance;
    private String quirks;

    private String background;
    private String motivation;

    private Date createdAt;
    private Date updatedAt;

    public BasicNPC() {
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
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
}
