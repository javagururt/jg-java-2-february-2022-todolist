package com.javaguru.todolist.repository;

import com.javaguru.todolist.domain.ToDoEntity;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ArrayListToDoRepository implements ToDoRepository {

    private List<ToDoEntity> database = new ArrayList<>();
    private int idSequence = 0;

    @Override
    public ToDoEntity save(ToDoEntity toDoEntity) {
        if (toDoEntity.getId() != null) {
            return update(toDoEntity);
        } else {
            toDoEntity.setId(idSequence);
            idSequence += 1000;
            database.add(toDoEntity);
        }
        return toDoEntity;
    }

    private ToDoEntity update(ToDoEntity toDoEntity) {
        for (int i = 0; i < database.size(); i++) {
            var existingEntity = database.get(i);
            if (existingEntity.getId().equals(toDoEntity.getId())) {
                database.set(i, toDoEntity);
                return toDoEntity;
            }
        }
        throw new IllegalStateException("Failed to update");
    }

    @Override
    public List<ToDoEntity> findAll() {
        return database;
    }

    @Override
    public Optional<ToDoEntity> findById(Integer id) {
        return database.stream()
                .filter(entity -> entity.getId().equals(id))
                .findFirst();
    }
}
