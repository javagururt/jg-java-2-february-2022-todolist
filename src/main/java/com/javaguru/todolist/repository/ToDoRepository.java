package com.javaguru.todolist.repository;

import com.javaguru.todolist.domain.ToDoEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface ToDoRepository extends JpaRepository<ToDoEntity, Integer> {

    List<ToDoEntity> findAllByName(String name);

    Optional<ToDoEntity> findFirstByName(String name);

    //    @Query(value = "SELECT * FROM todo td INNER JOIN users u on td.user_id = u.id " +
//            "WHERE u.username = :username", nativeQuery = true)
    @Query("SELECT td FROM ToDoEntity td LEFT JOIN UserEntity u ON td.userId = u.id" +
            " WHERE u.username = :username")
    List<ToDoEntity> findAllByUserName(@Param("username") String username);
}
