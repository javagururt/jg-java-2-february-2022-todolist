package com.javaguru.todolist.core.validation;

import com.javaguru.todolist.dto.AddToDoRequest;

import org.springframework.stereotype.Component;

@Component
public class ToDoDescriptionNullValidationRule implements ValidationRule {
    @Override
    public void validate(AddToDoRequest entity) {
        if (entity.getDescription() == null) {
            throw new ValidationException("ToDo description must not be null");
        }
    }
}
