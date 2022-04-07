package com.javaguru.todolist.core;

import com.javaguru.todolist.core.validation.ValidationService;
import com.javaguru.todolist.domain.ToDoEntity;
import com.javaguru.todolist.dto.AddToDoRequest;
import com.javaguru.todolist.dto.AddToDoResponse;
import com.javaguru.todolist.repository.HibernateRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddToDoService {

    @Autowired
    private HibernateRepository<ToDoEntity> todoRepository;

    @Autowired
    private ValidationService validationService;

    public AddToDoResponse add(AddToDoRequest request) {
        System.out.println("Received request: " + request);
        var validationResult = validationService.validate(request);
        if (!validationResult.isEmpty()) {
            System.out.println("Validation failed, errors: " + validationResult);
            var response = new AddToDoResponse();
            response.setErrors(validationResult);
            return response;
        }
//        var user = userRepository.findById(request.getUserId())
//                .orElseThrow(() -> new IllegalArgumentException("User with id " + request.getUserId() + " is not found."));

        var entity = convert(request);
        entity.setUserId(request.getUserId());
        var createdEntity = todoRepository.save(entity);
        System.out.println("Successfully saved: " + createdEntity);
        var response = new AddToDoResponse();
        response.setCreatedToDoId(createdEntity.getId());
        System.out.println("Sending response: " + response);
        return response;
    }

    private ToDoEntity convert(AddToDoRequest request) {
        ToDoEntity entity = new ToDoEntity();
        entity.setName(request.getName());
        entity.setDescription(request.getDescription());
        return entity;
    }
}
