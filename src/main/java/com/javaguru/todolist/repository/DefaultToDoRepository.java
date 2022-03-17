package com.javaguru.todolist.repository;

import com.javaguru.todolist.domain.ToDoEntity;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.Statement;
import java.util.List;
import java.util.Optional;

@Repository
class DefaultToDoRepository implements ToDoRepository {

    private final JdbcTemplate jdbcTemplate;

    DefaultToDoRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public ToDoEntity save(ToDoEntity toDoEntity) {
        var query = "INSERT INTO todo(name, description) VALUES (?, ?)";
        var keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(connection -> {
            var ps = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, toDoEntity.getName());
            ps.setString(2, toDoEntity.getDescription());
            return ps;
        }, keyHolder);
        toDoEntity.setId(keyHolder.getKey().intValue());
        return toDoEntity;
    }

    @Override
    public List<ToDoEntity> findAll() {
        return jdbcTemplate.query("SELECT * FROM todo", new BeanPropertyRowMapper(ToDoEntity.class));
    }

    @Override
    public Optional<ToDoEntity> findById(Integer id) {
        var result = (ToDoEntity) jdbcTemplate.queryForObject("SELECT * FROM todo WHERE id=?", new Object[]{id}, new BeanPropertyRowMapper(ToDoEntity.class));
        return Optional.ofNullable(result);
    }
}
