package com.javaguru.todolist.controller;

import com.javaguru.todolist.core.AddToDoService;
import com.javaguru.todolist.core.FindAllToDoService;
import com.javaguru.todolist.dto.AddToDoRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
@RequestMapping("/ui")
class ToDoUIController {

    private final FindAllToDoService findAllToDoService;
    private final AddToDoService addToDoService;

    @GetMapping("/findAllTodo")
    public String findAllTodo(Model model) {
        var response = findAllToDoService.findAll();
        model.addAttribute("todos", response);
        return "findAllTodo";
    }
    @GetMapping("/addTodo")
    public String addTodoView(Model model) {
        model.addAttribute("todo", new AddToDoRequest());
        return "addTodo";
    }
    @PostMapping("/addTodo")
    public String addTodo(@ModelAttribute AddToDoRequest todo) {
        addToDoService.add(todo);
        return "redirect:/ui/findAllTodo";
    }
}
