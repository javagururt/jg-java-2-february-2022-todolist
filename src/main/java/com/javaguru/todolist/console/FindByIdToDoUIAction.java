package com.javaguru.todolist.console;

import com.javaguru.todolist.core.GetToDoByIdService;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Order(3)
@Component
class FindByIdToDoUIAction implements UIAction {

    private final GetToDoByIdService getToDoByIdService;

    FindByIdToDoUIAction(GetToDoByIdService getToDoByIdService) {
        this.getToDoByIdService = getToDoByIdService;
    }

    @Override
    public void execute() {
        System.out.println("Please enter todo id:");
        var scanner = new Scanner(System.in);
        var id = scanner.nextInt();
        var result = getToDoByIdService.getById(id);
        System.out.println("Result: " + result);
    }

    @Override
    public String getActionName() {
        return "Find By ID";
    }
}
