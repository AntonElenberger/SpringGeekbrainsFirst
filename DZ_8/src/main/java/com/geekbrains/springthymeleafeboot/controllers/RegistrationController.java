package com.geekbrains.springthymeleafeboot.controllers;

import com.geekbrains.springthymeleafeboot.entities.SystemUser;
import com.geekbrains.springthymeleafeboot.entities.User;
import com.geekbrains.springthymeleafeboot.services.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class RegistrationController {
    UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    private final Logger logger = LoggerFactory.getLogger(RegistrationController.class);

    @InitBinder
    public void initBinder(WebDataBinder dataBinder) {
        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
        dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
    }

    @GetMapping("/showRegistrationForm")
    public String showMyLoginPage(Model model) {
        model.addAttribute("systemUser", new SystemUser());
        return "registration-form";
    }

    @PostMapping("/processRegistrationForm")
    public String processRegistrationForm(@Valid @ModelAttribute("systemUser") SystemUser systemUser, BindingResult bindingResult, Model model) {
        String userName = systemUser.getUserName();
        logger.debug("Processing registration form for: " + userName);
        if(bindingResult.hasErrors()) return "registration-form";
        User existing = userService.findByUserName(userName);
        if(existing != null) {
            model.addAttribute("systemUser", systemUser);
            model.addAttribute("registrationError", "User with such username already exists");
            logger.debug("User already exists");
            return "registration-form";
        }

        userService.save(systemUser);
        logger.debug("User created with username: " + userName);
        return "registration-confirmation";
    }
}
