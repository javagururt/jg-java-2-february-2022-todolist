package com.javaguru.todolist.core;

import com.javaguru.todolist.domain.ToDoEntity;
import com.javaguru.todolist.dto.GetByIdToDoResponse;
import com.javaguru.todolist.dto.ToDoDTO;
import com.javaguru.todolist.repository.ToDoRepository;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class GetToDoByIdService {

    private final ToDoRepository toDoRepository;

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
