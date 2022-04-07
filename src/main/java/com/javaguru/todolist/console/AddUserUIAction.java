package com.javaguru.todolist.console;

import com.javaguru.todolist.core.UserService;
import com.javaguru.todolist.dto.AddUserRequest;

import org.springframework.stereotype.Component;

import java.util.Scanner;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
class AddUserUIAction implements UIAction {

    private final UserService userService;


    @Override
    public void execute() {
        System.out.println("Please enter username: ");
        var scanner = new Scanner(System.in);
        var username = scanner.nextLine();
        var request = new AddUserRequest();
        request.setUsername(username);

        var result = userService.addUser(request);
        System.out.println("User added: " + result);
    }

    @Override
    public String getActionName() {
        return "Add user";
    }
}
