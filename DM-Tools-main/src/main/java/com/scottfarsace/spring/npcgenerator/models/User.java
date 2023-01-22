/**
* User
*
* User stores information related to an existing login
* These users own NPC's
*
* @author  Scott
* @version 0.1
* @since   2023-01-15
* @status Done
*/

package com.scottfarsace.spring.npcgenerator.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "users")
public class User {

    // Synthetic key to provide uniqueness for each row
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // creates unique ID in MySQL
    private Long Id;

    @NotNull(message = "Enter username")
    @Size(min = 3, max = 128)
    private String name;

    @NotNull(message = "Enter email")
    @Size(min = 3, max = 128)
    @Email(message = "Enter a valid email")
    private String email;

    @NotNull(message = "Enter password")
    @Size(min = 3, max = 128)
    private String password;

    @Transient
    @NotNull(message = "Enter matching password")
    @Size(min = 3, max = 128)
    private String confirmPassword;

    @Column(updatable = false)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date createdAt;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date updatedAt;

    // Constructors

    public User() {
    }

    // RELATIONSHIPS:

    @OneToMany(mappedBy = "creator", fetch = FetchType.LAZY)
    private List<NPC> npcs;
    
    // GETTERS SETTERS:

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public List<NPC> getNpcs() {
        return npcs;
    }

    public void setNpcs(List<NPC> npcs) {
        this.npcs = npcs;
    }
}
