package core.validation;

import dto.AddToDoRequest;

public class ToDoDescriptionMaxLengthValidationRule implements ValidationRule {
    @Override
    public void validate(AddToDoRequest request) {
        if (request.getDescription().length() > 10) {
            throw new ValidationException("ToDo description length must be less than 10 but actual description length is "
                    + request.getName().length());
        }
    }
}
