package com.javaguru.todolist.core.validation;

import com.javaguru.todolist.dto.AddToDoRequest;

import org.springframework.stereotype.Component;

@Component
public class ToDoDescriptionMaxLengthValidationRule implements ValidationRule {
    @Override
    public void validate(AddToDoRequest request) {
        if (request.getDescription().length() > 10) {
            throw new ValidationException("ToDo description length must be less than 10 but actual description length is "
                    + request.getDescription().length());
        }
    }
}
