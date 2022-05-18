package com.javaguru.todolist.dto;

import lombok.Value;

@Value
public class SearchToDoRequest {

    String name;
    String description;
    Integer userId;
}
