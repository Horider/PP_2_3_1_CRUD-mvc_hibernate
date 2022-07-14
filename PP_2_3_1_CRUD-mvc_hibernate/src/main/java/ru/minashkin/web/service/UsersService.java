package ru.minashkin.web.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.minashkin.web.models.User;

import java.util.List;

@Service
public interface UsersService {

    List<User> findAll();

    User findOne(int id);

    @Transactional
    void save(User user);

    @Transactional
    void update(User userUpdate);

    @Transactional
    void delete(int id);
}
