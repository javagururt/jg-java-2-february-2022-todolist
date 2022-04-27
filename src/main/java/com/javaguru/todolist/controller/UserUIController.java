package com.javaguru.todolist.controller;

import com.javaguru.todolist.core.UserService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
@RequestMapping("/ui")
class UserUIController {

    private final UserService userService;

    @GetMapping("/users")
    public String findAllUsers(Model model) {
        return "users";
    }
}
