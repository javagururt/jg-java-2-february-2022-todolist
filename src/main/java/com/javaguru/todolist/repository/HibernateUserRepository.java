package com.javaguru.todolist.repository;

import com.javaguru.todolist.domain.UserEntity;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import lombok.AllArgsConstructor;

@Repository
@Transactional
@AllArgsConstructor
class HibernateUserRepository implements HibernateRepository<UserEntity> {

    private final SessionFactory sessionFactory;

    @Override
    public UserEntity save(UserEntity entity) {
        sessionFactory.openSession().save(entity);
        return entity;
    }

    @Override
    public List<UserEntity> findAll() {
        return sessionFactory.openSession().createQuery("SELECT u FROM user u").getResultList();
    }

    @Override
    public Optional<UserEntity> findById(Integer id) {
        var entity = sessionFactory.openSession().get(UserEntity.class, id);
        return Optional.ofNullable(entity);
    }

    @Override
    public void update(UserEntity entity) {
        sessionFactory.openSession().update(entity);
    }
}
