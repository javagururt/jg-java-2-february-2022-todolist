package com.javaguru.todolist.core;

import com.javaguru.todolist.domain.UserEntity;
import com.javaguru.todolist.dto.AddUserRequest;
import com.javaguru.todolist.dto.AddUserResponse;
import com.javaguru.todolist.repository.UserRepository;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UserService {

    private final UserRepository repository;

    public AddUserResponse addUser(AddUserRequest request) {
        var entity = convert(request);
        repository.save(entity);
        var response = new AddUserResponse();
        response.setCreatedUserId(entity.getId());
        return response;
    }

    private UserEntity convert(AddUserRequest request) {
        var entity = new UserEntity();
        entity.setUsername(request.getUsername());
        return entity;
    }

}
