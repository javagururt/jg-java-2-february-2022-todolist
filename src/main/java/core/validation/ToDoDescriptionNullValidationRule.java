package core.validation;

import domain.ToDoEntity;

public class ToDoDescriptionNullValidationRule implements ValidationRule {
    @Override
    public void validate(ToDoEntity entity) {
        if (entity.getDescription() == null) {
            throw new ValidationException("ToDo description must not be null");
        }
    }
}
