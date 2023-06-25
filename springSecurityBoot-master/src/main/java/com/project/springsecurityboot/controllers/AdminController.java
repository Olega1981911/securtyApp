package com.project.springsecurityboot.controllers;


import com.project.springsecurityboot.models.User;
import com.project.springsecurityboot.service.RoleServiceImpl;
import com.project.springsecurityboot.service.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.Principal;
import java.util.Set;


@Controller
@RequestMapping("/admin")
public class AdminController {
    private final UserDetailsServiceImpl userDetailsService;
    private final RoleServiceImpl roleService;

    @Autowired
    public AdminController(UserDetailsServiceImpl userDetailsService, RoleServiceImpl roleService) {
        this.userDetailsService = userDetailsService;
        this.roleService = roleService;
    }


 @GetMapping()
    public String pageToViewAllUsers(ModelMap model, Principal principal) {
        User user = userDetailsService.findByName(principal.getName());
        model.addAttribute("user", user);
        model.addAttribute("allUsers", userDetailsService.findAll());
        model.addAttribute("roleUser", roleService.getAllRoles());
        return "admin";
    }


  /*  @PostMapping()
    public String addUser(@ModelAttribute("newUser") @Valid User user,
                          @ModelAttribute("role") Long roleId) {
        return getString(user, roleId);
    }

    private String getString(@ModelAttribute("newUser") User user,
                             @ModelAttribute("role") Long roleId) {
        user.setRoles(Set.of(roleService.getOneRole(roleId)));
        userDetailsService.saveUser(user);
        return "redirect:/admin";
    }

    @GetMapping("/update/{id}")
    public String prepareToUpdateUser(Model model, @PathVariable("id") Long id) {
        User user = userDetailsService.findOne(id);
        model.addAttribute("user", user);
        model.addAttribute("roleUser", roleService.getAllRoles());
        return "admin";
    }


    @PutMapping("/update/{id}")
    public String updateUser(@ModelAttribute("user") @Valid User user,
                             @ModelAttribute("role") Long roleId) {
        return getString(user, roleId);
    }

    @GetMapping("/delete/{id}")
    public String prepareToDeleteUser(Model model, @PathVariable("id") Long id) {
        User user = userDetailsService.findOne(id);
        model.addAttribute("user", user);
        model.addAttribute("roleUser", roleService.getAllRoles());
        return "admin";
    }

    @DeleteMapping("/delete/{id}")
    public String deleteUser(@PathVariable("id") Long id) {
        userDetailsService.deleteUser(id);
        return "redirect:/admin";
    }*/
}
