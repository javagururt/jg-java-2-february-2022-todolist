package com.javaguru.todolist.core.validation;

import com.javaguru.todolist.dto.AddToDoRequest;

public interface ValidationRule {

    void validate(AddToDoRequest request);

    default void checkNotNull(AddToDoRequest entity) {
        if (entity == null) {
            throw new ValidationException("ToDo must not be null.");
        }
    }
}
