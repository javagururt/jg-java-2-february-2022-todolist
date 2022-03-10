package com.javaguru.todolist.dto;

import java.util.List;

import com.javaguru.todolist.core.validation.CoreError;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AddToDoResponse {

    private Integer createdToDoId;
    private List<CoreError> errors;

}
