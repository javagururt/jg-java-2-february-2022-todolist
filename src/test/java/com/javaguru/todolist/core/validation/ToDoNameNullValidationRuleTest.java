package com.javaguru.todolist.core.validation;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.javaguru.todolist.dto.AddToDoRequest;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ToDoNameNullValidationRuleTest {

    @Mock
    private AddToDoRequest request;

    ToDoNameNullValidationRule validationRule = new ToDoNameNullValidationRule();

    @Test
    void shouldThrowExceptionWhenNameIsNull() {
        when(request.getName()).thenReturn(null);
        assertThrows(ValidationException.class, () -> validationRule.validate(request));
    }

    @Test
    void shouldNotThrowException() {
        var request = new AddToDoRequest();
        request.setName("TEST_NAME");
        assertDoesNotThrow(() -> validationRule.validate(request));
    }
}