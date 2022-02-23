package core.validation;

import dto.AddToDoRequest;

public class ToDoNameNullValidationRule implements ValidationRule {

    @Override
    public void validate(AddToDoRequest entity) {
        if (entity.getName() == null) {
            throw new ValidationException("ToDo name must be not null");
        }
    }
}
