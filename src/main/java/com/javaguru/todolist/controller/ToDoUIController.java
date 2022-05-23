package com.javaguru.todolist.controller;

import com.javaguru.todolist.core.AddToDoService;
import com.javaguru.todolist.core.FindAllToDoService;
import com.javaguru.todolist.core.GetToDoByIdService;
import com.javaguru.todolist.core.UpdateToDoService;
import com.javaguru.todolist.dto.AddToDoRequest;
import com.javaguru.todolist.dto.UpdateToDoRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
@RequestMapping("/ui")
class ToDoUIController {

    private final FindAllToDoService findAllToDoService;
    private final AddToDoService addToDoService;
    private final GetToDoByIdService getToDoByIdService;
    private final UpdateToDoService updateToDoService;

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

    @GetMapping("/updateTodo")
    public String updateTodoView(Model model, @RequestParam Integer id) {
        var response = getToDoByIdService.getById(id);
        var todo = response.getTodo();
        var attributeValue = new UpdateToDoRequest();
        attributeValue.setId(todo.getId());
        attributeValue.setName(todo.getName());
        attributeValue.setDescription(todo.getDescription());
        model.addAttribute("todo", attributeValue);
        return "updateTodo";
    }

    @PostMapping("/addTodo")
    public String addTodo(@ModelAttribute AddToDoRequest todo) {
        addToDoService.add(todo);
        return "redirect:/ui/findAllTodo";
    }

    @PostMapping("/updateTodo")
    public String updateTodo(@ModelAttribute UpdateToDoRequest todo) {
        updateToDoService.update(todo);
        return "redirect:/ui/findAllTodo";
    }
}
