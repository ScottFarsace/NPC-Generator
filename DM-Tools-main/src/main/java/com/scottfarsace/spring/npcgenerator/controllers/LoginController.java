/**
* LoginController
*
* LoginController controls the login portion of the website
* No other functionality executes until this process is completed
*
* @author  Scott
* @version 0.1
* @since   2023-01-15
* @status Done
*/
package com.scottfarsace.spring.npcgenerator.controllers;

import javax.servlet.http.HttpSession;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.scottfarsace.spring.npcgenerator.models.LoginUser;
import com.scottfarsace.spring.npcgenerator.models.User;

import com.scottfarsace.spring.npcgenerator.services.LoginService;

@Controller
public class LoginController {

    @Autowired
    private LoginService loginService;

    @GetMapping("/")
    public String login(@ModelAttribute("registerUser") User newUser,
            @ModelAttribute("loginUser") LoginUser loginUser) {
        return "login.jsp";
    }

    @PostMapping("/login")
    public String loginUser(@Valid @ModelAttribute("loginUser") LoginUser loginUser, BindingResult result,
            @ModelAttribute("registerUser") User newUser, HttpSession session) {
        User foundUser = loginService.login(loginUser, result);
        if (result.hasErrors()) {
            return "login.jsp";
        }
        session.setAttribute("userId", foundUser.getId()); // Register New User
        return "redirect:/home"; // Go to Dashboard
    }

    @PostMapping("/register")
    public String registerUser(@Valid @ModelAttribute("registerUser") User newUser, BindingResult result,
            HttpSession session, @ModelAttribute("loginUser") LoginUser loginUser) {
        User changedUser = loginService.register(newUser, result); // calls additional validations from service
        if (result.hasErrors()) {// this (below) is the baseline validation layer
            return "login.jsp";
        }
        session.setAttribute("userId", changedUser.getId()); // Register New User
        return "redirect:/home"; // Go to Dashboard
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate(); // terminates session
        return "redirect:/";
    }
}
