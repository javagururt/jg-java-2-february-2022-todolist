package core.validation;

public class CoreError {

    private String message;

    public CoreError(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    @Override
    public String toString() {
        return "ToDoError{" +
                "message='" + message + '\'' +
                '}';
    }
}
