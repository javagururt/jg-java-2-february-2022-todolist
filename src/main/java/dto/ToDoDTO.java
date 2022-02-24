package dto;

import java.util.Objects;

public class ToDoDTO {

    private int id;
    private String name;
    private String description;

    public ToDoDTO(int id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ToDoDTO toDoDTO = (ToDoDTO) o;
        return id == toDoDTO.id && Objects.equals(name, toDoDTO.name) && Objects.equals(description, toDoDTO.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, description);
    }

    @Override
    public String toString() {
        return "ToDoDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
