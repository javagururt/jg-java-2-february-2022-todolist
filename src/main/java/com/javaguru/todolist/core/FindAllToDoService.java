package com.javaguru.todolist.core;

import com.javaguru.todolist.domain.ToDoEntity;
import com.javaguru.todolist.dto.ToDoDTO;
import com.javaguru.todolist.repository.ToDoRepository;

import org.springframework.data.domain.Example;
import org.springframework.stereotype.Component;

import java.util.List;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class FindAllToDoService {

    private final ToDoRepository repository;

    public List<ToDoDTO> findAllBy(String name, String description) {
        var exampleEntity = new ToDoEntity();
        exampleEntity.setName(name);
        exampleEntity.setDescription(description);
        return repository.findAll(Example.of(exampleEntity)).stream()
                .map(this::convert)
                .toList();
    }

    public List<ToDoDTO> findAll() {
        return repository.findAll().stream()
                .map(this::convert)
                .toList();
    }

    public List<ToDoDTO> findAllByUserName(String username) {
        return repository.findAllByUserName(username).stream()
                .map(this::convert)
                .toList();
    }

    private ToDoDTO convert(ToDoEntity entity) {
        return new ToDoDTO(entity.getId(), entity.getName(), entity.getDescription());
    }
}
