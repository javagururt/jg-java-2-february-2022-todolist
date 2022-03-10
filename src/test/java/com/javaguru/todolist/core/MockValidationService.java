package com.javaguru.todolist.core;

import java.util.List;

import com.javaguru.todolist.core.validation.CoreError;
import com.javaguru.todolist.core.validation.ValidationRule;
import com.javaguru.todolist.core.validation.ValidationService;
import com.javaguru.todolist.dto.AddToDoRequest;

class MockValidationService extends ValidationService {
    public MockValidationService(List<ValidationRule> validationRules) {
        super(validationRules);
    }

    @Override
    public List<CoreError> validate(AddToDoRequest request) {
        //mock
        return List.of();
    }
}
