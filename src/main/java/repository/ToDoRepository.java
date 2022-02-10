package repository;

import java.util.List;

import domain.ToDoEntity;

public interface ToDoRepository {

    ToDoEntity save(ToDoEntity toDoEntity);

    List<ToDoEntity> findAll();
}
