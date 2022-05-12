package com.javaguru.todolist.dto;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AddToDoRequest {
    @NotBlank
    @Length(min = 3, max = 15)
    private String name;
    @NotNull
    private String description;
    @Range(min = 1)
    private Integer userId;
}
