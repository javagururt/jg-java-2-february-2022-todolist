package core.validation;

import domain.ToDoEntity;

public interface ValidationRule {

    void validate(ToDoEntity entity);

    default void checkNotNull(ToDoEntity entity) {
        if (entity == null) {
            throw new ValidationException("ToDo must not be null.");
        }
    }
}
