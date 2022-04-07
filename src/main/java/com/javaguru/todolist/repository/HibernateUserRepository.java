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

    private SessionFactory sessionFactory;

    @Override
    public UserEntity save(UserEntity entity) {
        sessionFactory.getCurrentSession().save(entity);
        return entity;
    }

    @Override
    public List<UserEntity> findAll() {
        return sessionFactory.getCurrentSession().createQuery("SELECT u FROM users u").getResultList();
    }

    @Override
    public Optional<UserEntity> findById(Integer id) {
        var entity = sessionFactory.getCurrentSession().get(UserEntity.class, id);
        return Optional.ofNullable(entity);
    }
}
