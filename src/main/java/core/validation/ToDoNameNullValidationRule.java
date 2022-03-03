package core.validation;

import dto.AddToDoRequest;

public class ToDoNameNullValidationRule implements ValidationRule {

    @Override
    public void validate(AddToDoRequest request) {
        if (request.getName() == null) {
            throw new ValidationException("ToDo name must be not null");
        }
    }
}
