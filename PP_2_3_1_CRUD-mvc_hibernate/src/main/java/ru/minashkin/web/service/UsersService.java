package ru.minashkin.web.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.minashkin.web.models.User;

import java.util.List;

@Service
public interface UsersService {

    List<User> findAll();

    User findOne(int id);

    void save(User user);

    void update(int id, User userUpdate);

    void delete(int id);
}
