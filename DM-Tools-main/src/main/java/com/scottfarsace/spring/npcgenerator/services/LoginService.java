package com.scottfarsace.spring.npcgenerator.services;

import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.scottfarsace.spring.npcgenerator.models.LoginUser;
import com.scottfarsace.spring.npcgenerator.models.User;

import com.scottfarsace.spring.npcgenerator.repositories.LoginRepository;

@Service
public class LoginService {

    @Autowired
    private LoginRepository loginRepo;

    public User register(User newUser, BindingResult result) {
        // check if passwords agree:
        if (!newUser.getConfirmPassword().equals(newUser.getPassword())) {
            result.rejectValue("confirmPassword", "Matches", "Password does not match");
        }
        // check for unique email:
        Optional<User> optionalUser = loginRepo.findByEmail(newUser.getEmail());
        if (optionalUser.isPresent()) {
            result.rejectValue("email", "Matches", "Email in use");
        }
        // Return the user back - if these validations are ok
        if (result.hasErrors()) {
            return null;
        } else {
            // if valid, hash the password:
            String hashedPassword = BCrypt.hashpw(newUser.getPassword(), BCrypt.gensalt());
            newUser.setPassword(hashedPassword); // saves hashed pass
            return loginRepo.save(newUser);
        }
    }

//validations for checking valid login
    public User login(LoginUser newLogin, BindingResult result) {
        // check if the given email is found:
        Optional<User> optionalUser = loginRepo.findByEmail(newLogin.getLoginEmail());
        if (!optionalUser.isPresent()) { // if user is NOT found:
            result.rejectValue("loginEmail", "Matches", "Email / Password incorrect");
            result.rejectValue("loginPassword", "Matches", "Email / Password incorrect");
            return null; // terminates function if email is not found
        }
        // chech password
        User thisUser = optionalUser.get();
        if (!BCrypt.checkpw(newLogin.getLoginPassword(), thisUser.getPassword())) {
            result.rejectValue("loginEmail", "Matches", "Email / Password incorrect");
            result.rejectValue("loginPassword", "Matches", "Email / Password incorrect");
            return null; // invald login, bad password
        }
        return thisUser;
    }

    public User findById(Long id) {
        Optional<User> optionalUser = loginRepo.findById(id);
        return optionalUser.orElseGet(() -> null);
    }

    public User findByEmail(String email) {
        Optional<User> optionalUser = loginRepo.findByEmail(email);
        return optionalUser.orElseGet(() -> null);
    }

    public User updateUser(User newUser) {
        return loginRepo.save(newUser);
    }

    public void deleteUser(Long id) {
        loginRepo.deleteById(id);
    }
}
