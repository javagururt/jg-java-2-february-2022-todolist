package core.validation;

import org.junit.jupiter.api.Test;

import dto.AddToDoRequest;

import static org.junit.jupiter.api.Assertions.*;

class ToDoNameMinLengthValidationRuleTest {

    private ToDoNameMinLengthValidationRule rule = new ToDoNameMinLengthValidationRule();

    @Test
    void shouldThrowExceptionWhenNameLengthIncorrect() {

    }
}