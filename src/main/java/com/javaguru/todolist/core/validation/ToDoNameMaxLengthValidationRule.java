package com.javaguru.todolist.core.validation;

import com.javaguru.todolist.dto.AddToDoRequest;

import org.springframework.stereotype.Component;

@Component
public class ToDoNameMaxLengthValidationRule implements ValidationRule {
    @Override
    public void validate(AddToDoRequest entity) {
        if (entity.getName().length() > 10) {
            throw new ValidationException("ToDo name length must be less than 10 but actual name length is "
                    + entity.getName().length());
        }
    }
}
