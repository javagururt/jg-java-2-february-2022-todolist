package com.javaguru.todolist.core;

import com.javaguru.todolist.core.validation.ValidationService;
import com.javaguru.todolist.domain.ToDoEntity;
import com.javaguru.todolist.dto.AddToDoRequest;
import com.javaguru.todolist.dto.AddToDoResponse;
import com.javaguru.todolist.repository.HibernateRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class AddToDoService {

    @Autowired
    private HibernateRepository<ToDoEntity> todoRepository;

    @Autowired
    private ValidationService validationService;

    public AddToDoResponse add(AddToDoRequest request) {
        log.info("Received request: {}", request);
        var validationResult = validationService.validate(request);
        if (!validationResult.isEmpty()) {
            log.warn("Validation failed, error: {}", validationResult);
            var response = new AddToDoResponse();
            response.setErrors(validationResult);
            return response;
        }
        var entity = convert(request);
        entity.setUserId(request.getUserId());
        var createdEntity = todoRepository.save(entity);
        log.debug("Successfully saved: {}", createdEntity);
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
