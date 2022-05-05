package com.javaguru.todolist.core.converters;

import com.javaguru.todolist.domain.ToDoEntity;
import com.javaguru.todolist.dto.AddToDoRequest;

import org.springframework.stereotype.Component;

@Component
public class AddToDoRequestToToDoEntityConverter {

    public ToDoEntity convert(AddToDoRequest request) {
        ToDoEntity entity = new ToDoEntity();
        entity.setName(request.getName());
        entity.setDescription(request.getDescription());
        entity.setUserId(request.getUserId());
        return entity;
    }
}
