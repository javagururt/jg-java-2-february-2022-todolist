package com.javaguru.todolist.core;

import com.javaguru.todolist.domain.ToDoEntity;
import com.javaguru.todolist.dto.AddToDoRequest;
import com.javaguru.todolist.dto.AddToDoResponse;
import com.javaguru.todolist.repository.ToDoRepository;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@AllArgsConstructor
public class AddToDoService {

    private final ToDoRepository repository;

    public AddToDoResponse add(AddToDoRequest request) {
        log.info("Received request: {}", request);
        var entity = convert(request);
        entity.setUserId(request.getUserId());
        var createdEntity = repository.save(entity);
        log.info("Successfully saved: {}", createdEntity);
        var response = new AddToDoResponse();
        response.setCreatedToDoId(createdEntity.getId());
        log.debug("Sending response: {}", response);
        return response;
    }

    private ToDoEntity convert(AddToDoRequest request) {
        ToDoEntity entity = new ToDoEntity();
        entity.setName(request.getName());
        entity.setDescription(request.getDescription());
        return entity;
    }
}
