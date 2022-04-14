package com.javaguru.todolist.console;

import com.javaguru.todolist.core.FindAllToDoService;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Order(2)
@Component
public class FindAllToDoUIAction implements UIAction {

    private final FindAllToDoService findAllToDoService;

    public FindAllToDoUIAction(FindAllToDoService findAllToDoService) {
        this.findAllToDoService = findAllToDoService;
    }

    @Override
    public void execute() {
        var response = findAllToDoService.findAll();
        System.out.println(response);
    }

    @Override
    public String getActionName() {
        return "Find All ToDo";
    }
}
