package com.javaguru.todolist.repository;

import com.javaguru.todolist.domain.ToDoEntity;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

@Repository
@Transactional
class HibernateToDoRepository implements HibernateRepository {

    private final SessionFactory sessionFactory;

    HibernateToDoRepository(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public ToDoEntity save(ToDoEntity toDoEntity) {
        sessionFactory.getCurrentSession().save(toDoEntity);
        return toDoEntity;
    }

    @Override
    public List<ToDoEntity> findAll() {
//        return sessionFactory.getCurrentSession().createCriteria(ToDoEntity.class).list();
        return sessionFactory.getCurrentSession().createQuery("SELECT t FROM todo t").getResultList();
    }

    @Override
    public Optional<ToDoEntity> findById(Integer id) {
        var entity = sessionFactory.getCurrentSession().get(ToDoEntity.class, id);
        return Optional.ofNullable(entity);
    }
}