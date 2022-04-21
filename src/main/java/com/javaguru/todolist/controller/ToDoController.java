package com.javaguru.todolist.controller;

import com.javaguru.todolist.core.AddToDoService;
import com.javaguru.todolist.core.FindAllToDoService;
import com.javaguru.todolist.core.GetToDoByIdService;
import com.javaguru.todolist.dto.AddToDoRequest;
import com.javaguru.todolist.dto.AddToDoResponse;
import com.javaguru.todolist.dto.FindAllToDoResponse;
import com.javaguru.todolist.dto.GetByIdToDoResponse;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@AllArgsConstructor
class ToDoController {

    private final FindAllToDoService findAllToDoService;
    private final GetToDoByIdService getToDoByIdService;
    private final AddToDoService addToDoService;

    @GetMapping("/todos")
    public FindAllToDoResponse findAll() {
        return findAllToDoService.findAll();
    }

    @GetMapping("/todos/{id}")
    public GetByIdToDoResponse findById(@PathVariable("id") Integer id) {
        return getToDoByIdService.getById(id);
    }

    @PostMapping("/todos")
    public AddToDoResponse add(@RequestBody AddToDoRequest request) {
        return addToDoService.add(request);
    }

}
