package core.validation;

import domain.ToDoEntity;

public class ToDoDescriptionMaxLengthValidationRule implements ValidationRule {
    @Override
    public void validate(ToDoEntity entity) {
        if (entity.getDescription().length() > 10) {
            throw new ValidationException("ToDo description length must be less than 10 but actual description length is "
                    + entity.getName().length());
        }
    }
}
