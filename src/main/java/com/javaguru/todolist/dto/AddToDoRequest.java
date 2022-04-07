package com.javaguru.todolist.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@NoArgsConstructor
public class AddToDoRequest {
    @NonNull
    private String name;
    private String description;
    private Integer userId;
}
