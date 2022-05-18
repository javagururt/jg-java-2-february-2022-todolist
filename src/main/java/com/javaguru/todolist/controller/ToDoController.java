package com.javaguru.todolist.controller;

import com.javaguru.todolist.core.AddToDoService;
import com.javaguru.todolist.core.FindAllToDoService;
import com.javaguru.todolist.core.GetToDoByIdService;
import com.javaguru.todolist.core.UpdateToDoService;
import com.javaguru.todolist.dto.AddToDoRequest;
import com.javaguru.todolist.dto.AddToDoResponse;
import com.javaguru.todolist.dto.GetByIdToDoResponse;
import com.javaguru.todolist.dto.SearchToDoRequest;
import com.javaguru.todolist.dto.ToDoDTO;
import com.javaguru.todolist.dto.UpdateToDoRequest;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/todos")
@AllArgsConstructor
class ToDoController {

    private final FindAllToDoService findAllToDoService;
    private final GetToDoByIdService getToDoByIdService;
    private final AddToDoService addToDoService;
    private final UpdateToDoService updateToDoService;

    @GetMapping
    public List<ToDoDTO> findAll(@RequestParam(required = false) String name,
                                 @RequestParam(required = false) String description,
                                 @RequestParam(required = false) Integer userId) {
        var request = new SearchToDoRequest(name, description, userId);
        return findAllToDoService.findAllBy(request);
    }

    // /todos/1?name=123&description=test 3&userId=1
    @GetMapping(value = "/{id}")
    public GetByIdToDoResponse findById(@PathVariable("id") Integer id) {
        return getToDoByIdService.getById(id);
    }

    @PostMapping
    public AddToDoResponse add(@RequestBody AddToDoRequest request) {
        return addToDoService.add(request);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable("id") Integer id, @RequestBody UpdateToDoRequest request) {
        updateToDoService.update(request);
    }

}
