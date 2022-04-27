package com.javaguru.todolist.repository;

import com.javaguru.todolist.domain.ToDoEntity;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

@Repository
@Transactional
public class HibernateToDoRepository implements HibernateRepository<ToDoEntity> {

    private final SessionFactory sessionFactory;

    HibernateToDoRepository(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public ToDoEntity save(ToDoEntity toDoEntity) {
        try (var session = sessionFactory.openSession()) {
            session.save(toDoEntity);
            return toDoEntity;
        }
    }

    @Override
    public List<ToDoEntity> findAll() {
        try (var session = sessionFactory.openSession()) {
            return session.createQuery("SELECT t FROM ToDoEntity t").getResultList();
        }
    }

    @Override
    public Optional<ToDoEntity> findById(Integer id) {
        try (var session = sessionFactory.openSession()) {
            var entity = session.get(ToDoEntity.class, id);
            return Optional.ofNullable(entity);
        }
    }

    @Override
    public void update(ToDoEntity entity) {
        try (var session = sessionFactory.openSession()) {
            session.update(entity);
        }
    }
}
