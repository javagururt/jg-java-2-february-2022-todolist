package com.javaguru.todolist.repository;

import java.util.List;
import java.util.Optional;

import com.javaguru.todolist.domain.ToDoEntity;

public interface HibernateRepository<T> {

    T save(T entity);

    List<T> findAll();

    Optional<T> findById(Integer id);
}
