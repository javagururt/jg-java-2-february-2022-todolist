package dto;

import java.util.List;
import java.util.Objects;

public class FindAllToDoResponse {

    private List<ToDoDTO> todos;

    public FindAllToDoResponse(List<ToDoDTO> todos) {
        this.todos = todos;
    }

    public List<ToDoDTO> getTodos() {
        return todos;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FindAllToDoResponse that = (FindAllToDoResponse) o;
        return Objects.equals(todos, that.todos);
    }

    @Override
    public int hashCode() {
        return Objects.hash(todos);
    }

    @Override
    public String toString() {
        return "FindAllToDoResponse{" +
                "todos=" + todos +
                '}';
    }
}
