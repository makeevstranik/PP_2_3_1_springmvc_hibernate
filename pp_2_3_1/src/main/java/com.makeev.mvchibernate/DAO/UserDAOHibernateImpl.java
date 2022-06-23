package com.makeev.mvchibernate.DAO;

import com.makeev.mvchibernate.model.User;
import org.springframework.stereotype.Repository;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserDAOHibernateImpl implements DAO<User, Long> {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void save(User user) {
        entityManager.persist(user);
    }

    @Override
    public User readById(Long id) {
        return entityManager.find(User.class, id);
    }

    @Override
    public List<User> readAll() {
        TypedQuery<User> typedQuery = entityManager.createQuery("select u from User u", User.class);
        return typedQuery.getResultList();
    }

    @Override
    public void update(User user) {
        entityManager.merge(user);
    }

    @Override
    public void deleteById(Long id) {
        entityManager.remove(readById(id));
    }

    @Override
    public void delete(User user) {
        entityManager.remove(user);
    }
}
