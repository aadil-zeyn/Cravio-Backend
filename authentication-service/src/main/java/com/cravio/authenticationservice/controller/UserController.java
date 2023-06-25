package com.cravio.authenticationservice.controller;


import com.cravio.authenticationservice.dto.UserRegistrationRequest;
import com.cravio.authenticationservice.model.User;
import com.cravio.authenticationservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import javax.validation.Valid;

@RestController
@RequestMapping("/api/auth")
public class UserController {

    @Autowired
    private UserService userService;

    @PostConstruct
    public void initRoleAndUser() {
        userService.initRoleAndUser();
    }

    @PostMapping({"/registerNewUser"})
    public User registerNewUser(@RequestBody @Valid UserRegistrationRequest userRegistrationRequest) {
        return userService.registerNewUser(userRegistrationRequest);
    }
    @PostMapping({"/registerNewKitchenStaff"})
    public User registerNewKitchenStaff(@RequestBody @Valid UserRegistrationRequest userRegistrationRequest) {
        return userService.registerNewKitchenStaff(userRegistrationRequest);
    }

    @GetMapping({"/forAdmin"})
    @PreAuthorize("hasRole('Admin')")
    public String forAdmin(){
        return "This URL is only accessible to the admin";
    }

    @GetMapping({"/forUser"})
    @PreAuthorize("hasRole('User')")
    public String forUser(){
        return "This URL is only accessible to the user";
    }

    @GetMapping({"/forKitchenStaff"})
    @PreAuthorize("hasRole('KitchenStaff')")
    public String forKitchenstaff(){
        return "This URL is only accessible to the kitchen staff";
    }
}
