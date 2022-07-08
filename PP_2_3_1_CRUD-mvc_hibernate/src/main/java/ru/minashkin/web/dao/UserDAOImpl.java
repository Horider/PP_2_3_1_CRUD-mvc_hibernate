package ru.minashkin.web.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.minashkin.web.models.User;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

@Repository
@Transactional(readOnly = true)
public class UserDAOImpl implements UserDAO{

    private final EntityManager entityManager;

    @Autowired
    public UserDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<User> findAll() {
        String command = "FROM User";
        Query query = entityManager.createQuery(command);
        return query.getResultList();
    }

    @Override
    public User findOne(int id) {
        return entityManager.find(User.class, id);
    }

    @Override
    @Transactional
    public void save(User user) {
        entityManager.persist(user);
    }

    @Override
    @Transactional
    public void update(int id, User userUpdate) {
        User newUser = findOne(id);
        newUser.setName(userUpdate.getName());
        entityManager.merge(newUser);
    }

    @Override
    @Transactional
    public void delete(int id) {
        User user = entityManager.find(User.class, id);
        if (user != null) {
            entityManager.remove(user);
        }
    }
}