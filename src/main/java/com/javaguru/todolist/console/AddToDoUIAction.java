package com.javaguru.todolist.console;

import com.javaguru.todolist.core.AddToDoService;
import com.javaguru.todolist.dto.AddToDoRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class AddToDoUIAction implements UIAction {

    private final AddToDoService addTaskService;

    @Autowired
    public AddToDoUIAction(AddToDoService addTaskService) {
        this.addTaskService = addTaskService;
    }

    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter todo name: ");
        String name = scanner.nextLine();
        System.out.println("Please enter todo description: ");
        String description = scanner.nextLine();

        var request = new AddToDoRequest();
        request.setName(name);
        request.setDescription(description);

        var response = addTaskService.add(request);
        System.out.println("Received response: " + response);
    }

    @Override
    public String getActionName() {
        return "Add ToDo";
    }
}