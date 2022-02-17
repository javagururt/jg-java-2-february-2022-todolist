package core.validation;

import domain.ToDoEntity;

public class ToDoNameMinLengthValidationRule implements ValidationRule {
    @Override
    public void validate(ToDoEntity entity) {
        if (entity.getName().length() < 3) {
            throw new ValidationException("ToDo name length must be greater than 3 but actual name length is "
                    + entity.getName().length());
        }
    }
}
