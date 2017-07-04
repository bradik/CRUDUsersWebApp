package com.bradik.webapp.dao;

import com.bradik.webapp.model.User;

import java.util.List;

/**
 * Created by Brad on 30.06.2017.
 */
public interface UserDao {
    public List<User> findAll();
    public User findById(int id);
    public void save(User user);
    public void update(User user);
    public void delete(int id);
}
