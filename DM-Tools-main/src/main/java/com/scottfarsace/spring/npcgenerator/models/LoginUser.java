/**
* LoginUser
*
* LoginUser stores information related to a new user login
* This class is near exclusively used for creating new logins
*
* @author  Scott
* @version 0.1
* @since   2023-01-15
* @status Done
*/

package com.scottfarsace.spring.npcgenerator.models;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class LoginUser {
    
    @NotNull()
    @NotEmpty(message = "Enter an email")
    @Email(message = "Enter a valid email")
    private String loginEmail;

    @NotNull()
    @NotEmpty(message = "Enter a valid password")
    @Size(min = 3, max = 128, message = "Password must be between 3 and 128 characters")
    private String loginPassword;

    public LoginUser() {
    }

    public String getLoginEmail() {
        return loginEmail;
    }

    public void setLoginEmail(String loginEmail) {
        this.loginEmail = loginEmail;
    }

    public String getLoginPassword() {
        return loginPassword;
    }

    public void setLoginPassword(String loginPassword) {
        this.loginPassword = loginPassword;
    }
}
