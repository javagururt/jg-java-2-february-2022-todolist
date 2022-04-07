package com.javaguru.todolist.dto;

import com.javaguru.todolist.core.validation.CoreError;

import java.util.List;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AddUserResponse {

    private Integer createdUserId;
    private List<CoreError> errors;

}
