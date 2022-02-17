package dto;

import java.util.List;
import java.util.Objects;

import core.validation.CoreError;

public class AddToDoResponse {

    private Integer createdToDoId;
    private List<CoreError> errors;

    public Integer getCreatedToDoId() {
        return createdToDoId;
    }

    public void setCreatedToDoId(Integer createdToDoId) {
        this.createdToDoId = createdToDoId;
    }

    public List<CoreError> getErrors() {
        return errors;
    }

    public void setErrors(List<CoreError> errors) {
        this.errors = errors;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AddToDoResponse that = (AddToDoResponse) o;
        return Objects.equals(createdToDoId, that.createdToDoId) && Objects.equals(errors, that.errors);
    }

    @Override
    public int hashCode() {
        return Objects.hash(createdToDoId, errors);
    }

    @Override
    public String toString() {
        return "AddToDoResponse{" +
                "createdToDoId=" + createdToDoId +
                ", errors=" + errors +
                '}';
    }
}
