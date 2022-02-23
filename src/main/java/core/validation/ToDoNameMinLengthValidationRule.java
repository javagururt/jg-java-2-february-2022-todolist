package core.validation;

import dto.AddToDoRequest;

public class ToDoNameMinLengthValidationRule implements ValidationRule {
    @Override
    public void validate(AddToDoRequest entity) {
        if (entity.getName().length() < 3) {
            throw new ValidationException("ToDo name length must be greater than 3 but actual name length is "
                    + entity.getName().length());
        }
    }
}
