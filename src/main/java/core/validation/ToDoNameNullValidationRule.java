package core.validation;

import domain.ToDoEntity;

public class ToDoNameNullValidationRule implements ValidationRule {

    @Override
    public void validate(ToDoEntity entity) {
        if (entity.getName() == null) {
            throw new ValidationException("ToDo name must be not null");
        }
    }
}
