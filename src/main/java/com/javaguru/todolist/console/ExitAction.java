package com.javaguru.todolist.console;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Order(5)
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
