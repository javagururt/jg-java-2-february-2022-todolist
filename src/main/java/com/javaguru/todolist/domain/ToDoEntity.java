package com.javaguru.todolist.domain;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "todo")
@Table(name = "todo")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ToDoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "name", unique = true, nullable = false, length = 50)
    private String name;
    @Column(name = "description")
    private String description;
//    @ManyToOne
//    @JoinColumn(name = "user_id", referencedColumnName = "id")
//    private UserEntity userEntity;
    @Column(name = "user_id")
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private Integer userId;

}
