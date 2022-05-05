package com.javaguru.todolist.dto;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AddToDoRequest {
    @NotNull
    @NotEmpty
    @Length(min = 3, max = 15)
    private String name;
    @NotNull
    @NotEmpty
    @Length(min = 3, max = 255)
    private String description;
    @Range(min = 0, max = 18)
    private Integer userId;
}
