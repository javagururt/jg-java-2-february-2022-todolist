package com.javaguru.todolist.core;

import com.javaguru.todolist.domain.ToDoEntity;
import com.javaguru.todolist.dto.FindAllToDoResponse;
import com.javaguru.todolist.dto.ToDoDTO;
import com.javaguru.todolist.repository.HibernateRepository;

import org.springframework.stereotype.Component;

@Component
public class FindAllToDoService {

    private final HibernateRepository repository;

    public FindAllToDoService(HibernateRepository repository) {
        this.repository = repository;
    }

    public FindAllToDoResponse findAll() {
        var dtos = repository.findAll().stream()
                .map(this::convert)
                .toList();
        return new FindAllToDoResponse(dtos);
    }

    private ToDoDTO convert(ToDoEntity entity) {
        return new ToDoDTO(entity.getId(), entity.getName(), entity.getDescription());
    }
}
