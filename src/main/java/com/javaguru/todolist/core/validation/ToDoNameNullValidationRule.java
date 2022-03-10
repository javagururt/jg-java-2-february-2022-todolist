package com.javaguru.todolist.core.validation;

import com.javaguru.todolist.dto.AddToDoRequest;

import org.springframework.stereotype.Component;

@Component
public class ToDoNameNullValidationRule implements ValidationRule {

    @Override
    public void validate(AddToDoRequest request) {
        if (request.getName() == null) {
            throw new ValidationException("ToDo name must be not null");
        }
    }
}
