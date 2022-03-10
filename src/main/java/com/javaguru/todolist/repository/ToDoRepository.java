package com.javaguru.todolist.repository;

import java.util.List;
import java.util.Optional;

import com.javaguru.todolist.domain.ToDoEntity;

public interface ToDoRepository {

    ToDoEntity save(ToDoEntity toDoEntity);

    List<ToDoEntity> findAll();

    Optional<ToDoEntity> findById(Integer id);
}
