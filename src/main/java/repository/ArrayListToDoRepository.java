package repository;

import java.util.ArrayList;
import java.util.List;

import domain.ToDoEntity;

public class ArrayListToDoRepository implements ToDoRepository {

    private List<ToDoEntity> database = new ArrayList<>();
    private int idSequence = 0;

    @Override
    public ToDoEntity save(ToDoEntity toDoEntity) {
        toDoEntity.setId(idSequence);
        idSequence++;
        database.add(toDoEntity);
        return toDoEntity;
    }

    @Override
    public List<ToDoEntity> findAll() {
        return database;
    }
}
