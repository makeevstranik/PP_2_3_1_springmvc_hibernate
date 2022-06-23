package com.makeev.mvchibernate.service;

import com.makeev.mvchibernate.DAO.DAO;
import com.makeev.mvchibernate.DAO.UserDAOHibernateImpl;
import com.makeev.mvchibernate.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
public class UserServiceImpl implements UserService {

    @Autowired
    private DAO<User, Long> userDAOHibernate;

    @Transactional
    @Override
    public void add(User user) {
        userDAOHibernate.save(user);
    }

    @Transactional(readOnly = true)
    @Override
    public List<User> getAllUsers() {
        return userDAOHibernate.readAll();
    }


    @Transactional(readOnly = true)
    @Override
    public User getUserById(Long id) {
        return userDAOHibernate.readById(id);
    }

    @Transactional
    @Override
    public void updateUser(User user) {
        userDAOHibernate.update(user);
    }

    @Transactional
    @Override
    public void deleteUser(User user) {
        userDAOHibernate.delete(user);
    }

    @Transactional
    @Override
    public void deleteUserById(Long id) {
        userDAOHibernate.deleteById(id);
    }
}
