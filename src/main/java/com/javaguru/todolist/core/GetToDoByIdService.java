package com.javaguru.todolist.core;

import com.javaguru.todolist.domain.ToDoEntity;
import com.javaguru.todolist.dto.GetByIdToDoResponse;
import com.javaguru.todolist.dto.ToDoDTO;
import com.javaguru.todolist.repository.HibernateRepository;

import org.springframework.stereotype.Component;

@Component
public class GetToDoByIdService {

    private final HibernateRepository<ToDoEntity> toDoRepository;

    public GetToDoByIdService(HibernateRepository<ToDoEntity> toDoRepository) {
        this.toDoRepository = toDoRepository;
    }

    public GetByIdToDoResponse getById(Integer id) {
        return toDoRepository.findById(id)
                .map(this::convert)
                .map(GetByIdToDoResponse::new)
                .orElseThrow(() -> new IllegalArgumentException("ToDo with id " + id + " is not found."));
    }

    private ToDoDTO convert(ToDoEntity entity) {
        return new ToDoDTO(entity.getId(), entity.getName(), entity.getDescription());
    }
}
