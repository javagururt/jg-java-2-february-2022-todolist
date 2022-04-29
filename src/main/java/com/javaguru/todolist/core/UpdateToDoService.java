package com.javaguru.todolist.core;

import com.javaguru.todolist.domain.ToDoEntity;
import com.javaguru.todolist.dto.UpdateToDoRequest;
import com.javaguru.todolist.repository.HibernateRepository;

import org.springframework.stereotype.Component;

import javax.transaction.Transactional;

@Component
public class UpdateToDoService {

    private final HibernateRepository<ToDoEntity> repository;

    public UpdateToDoService(HibernateRepository<ToDoEntity> repository) {
        this.repository = repository;
    }

    @Transactional
    public void update(UpdateToDoRequest request) {
        repository.findById(request.getId())
                .map(entity -> updateFields(entity, request))
                .ifPresent(repository::update);
    }

    private ToDoEntity updateFields(ToDoEntity entity, UpdateToDoRequest request) {
        var updatedEntity = new ToDoEntity();
        updatedEntity.setId(entity.getId());
        updatedEntity.setDescription(request.getDescription());
        updatedEntity.setName(request.getName());
        updatedEntity.setUserId(entity.getUserId());
        return updatedEntity;
    }
}
