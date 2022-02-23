package core.validation;

import dto.AddToDoRequest;

public class ToDoNameMaxLengthValidationRule implements ValidationRule {
    @Override
    public void validate(AddToDoRequest entity) {
        if (entity.getName().length() > 10) {
            throw new ValidationException("ToDo name length must be less than 10 but actual name length is "
                    + entity.getName().length());
        }
    }
}
