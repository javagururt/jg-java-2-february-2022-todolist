package com.javaguru.todolist.core;

import com.javaguru.todolist.domain.ToDoEntity;

import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class SearchToDoByUserIdSpecification implements Specification<ToDoEntity> {

    private final Integer userId;

    @Override
    public Predicate toPredicate(Root<ToDoEntity> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
        return criteriaBuilder.equal(root.get("userId"), userId);
    }
}
