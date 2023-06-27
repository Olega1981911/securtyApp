package com.project.springsecurityboot.controllers;


import com.project.springsecurityboot.models.User;
import com.project.springsecurityboot.service.RoleServiceImpl;
import com.project.springsecurityboot.service.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

@Controller
@RequestMapping("/")
public class PageUsers {

    private final UserDetailsServiceImpl userDetailsService;
    private final RoleServiceImpl roleService;

    @Autowired
    public PageUsers(UserDetailsServiceImpl userDetailsService, RoleServiceImpl roleService) {
        this.userDetailsService = userDetailsService;
        this.roleService = roleService;
    }

    @GetMapping("/")
    public String start() {
        return "/index";
    }



    @GetMapping("/user")
    public String pageForUserProfile(Model model, Principal principal) {
        model.addAttribute("user", userDetailsService.findByName(principal.getName()));

        return "user";
    }
    @GetMapping("/admin")
    public String pageToViewAllUsers(ModelMap model, Principal principal) {
        User user = userDetailsService.findByName(principal.getName());
        model.addAttribute("user", user);
        model.addAttribute("allUsers", userDetailsService.findAll());
        model.addAttribute("roleUser", roleService.getAllRoles());
        return "admin";
    }

}
