package ru.minashkin.web.dao;

import ru.minashkin.web.models.User;

import java.util.List;

public interface UserDAO {

    List<User> findAll();

    User findOne(int id);

    void save(User user);

    void update(User userUpdate);

    void delete(int id);
}
