package core.validation;

import dto.AddToDoRequest;

public class ToDoDescriptionNullValidationRule implements ValidationRule {
    @Override
    public void validate(AddToDoRequest entity) {
        if (entity.getDescription() == null) {
            throw new ValidationException("ToDo description must not be null");
        }
    }
}
