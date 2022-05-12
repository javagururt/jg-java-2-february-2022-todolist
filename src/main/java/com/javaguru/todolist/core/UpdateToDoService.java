package com.javaguru.todolist.core;

import com.javaguru.todolist.domain.ToDoEntity;
import com.javaguru.todolist.dto.UpdateToDoRequest;
import com.javaguru.todolist.repository.ToDoRepository;

import org.springframework.stereotype.Component;

import javax.transaction.Transactional;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class UpdateToDoService {

    private final ToDoRepository repository;

    @Transactional
    public void update(UpdateToDoRequest request) {
        repository.findById(request.getId())
                .map(entity -> updateFields(entity, request))
                .ifPresent(repository::save);
    }

    private ToDoEntity updateFields(ToDoEntity entity, UpdateToDoRequest request) {
        entity.setDescription(request.getDescription());
        entity.setName(request.getName());
        entity.setUserId(entity.getUserId());
        return entity;
    }
}
