package com.javaguru.todolist.console;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
class ExitAction implements UIAction {
    @Override
    public void execute() {
        System.out.println("Bye-bye");
        System.exit(0);
    }

    @Override
    public String getActionName() {
        return "Exit";
    }
}
