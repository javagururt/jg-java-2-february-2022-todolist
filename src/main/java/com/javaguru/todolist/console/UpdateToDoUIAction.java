package com.javaguru.todolist.console;

import java.util.Scanner;

import com.javaguru.todolist.core.GetToDoByIdService;
import com.javaguru.todolist.core.UpdateToDoService;
import com.javaguru.todolist.dto.UpdateToDoRequest;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;


@Order(4)
@Component
public class UpdateToDoUIAction implements UIAction {

    private final GetToDoByIdService getToDoByIdService;
    private final UpdateToDoService updateToDoService;

    public UpdateToDoUIAction(GetToDoByIdService getToDoByIdService, UpdateToDoService updateToDoService) {
        this.getToDoByIdService = getToDoByIdService;
        this.updateToDoService = updateToDoService;
    }

    @Override
    public void execute() {
        var scanner = new Scanner(System.in);
        System.out.println("Please enter ToDo id: ");
        var id = Integer.valueOf(scanner.nextLine());
        var foundToDoResponse = getToDoByIdService.getById(id);
        var todo = foundToDoResponse.getTodo();
        System.out.println("Please enter name");
        var name = scanner.nextLine();
        System.out.println("Please enter description");
        var description = scanner.nextLine();

        var updateRequest = new UpdateToDoRequest();
        updateRequest.setId(todo.getId());
        var updatedName = getUpdatedValue(name, todo.getName()) ;
        var updatedDescription = getUpdatedValue(description, todo.getDescription());

        updateRequest.setName(updatedName);
        updateRequest.setDescription(updatedDescription);

        updateToDoService.update(updateRequest);
    }

    public String getUpdatedValue(String newValue, String oldValue) {
        return newValue.equals("") ? oldValue : newValue;
    }

    public String getUpdatedValueLegacy(String newValue, String oldValue) {
        if (newValue.equals("")) {
            return oldValue;
        } else {
            return newValue;
        }
    }

    @Override
    public String getActionName() {
        return "Update ToDo";
    }
}
