package com.javaguru.todolist.repository;

import com.javaguru.todolist.domain.UserEntity;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Integer> {
}
