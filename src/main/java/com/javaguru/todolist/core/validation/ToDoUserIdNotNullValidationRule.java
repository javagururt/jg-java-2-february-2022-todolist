package com.javaguru.todolist.core.validation;

import com.javaguru.todolist.dto.AddToDoRequest;

class ToDoUserIdNotNullValidationRule implements ValidationRule {
    @Override
    public void validate(AddToDoRequest request) {
        if (request.getUserId() == null) {
            throw new ValidationException("User id must not be null.");
        }
    }
}
