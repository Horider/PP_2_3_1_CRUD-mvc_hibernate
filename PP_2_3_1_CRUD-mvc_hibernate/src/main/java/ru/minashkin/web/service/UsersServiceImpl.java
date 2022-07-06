package ru.minashkin.web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.minashkin.web.models.User;
import ru.minashkin.web.repositories.PeopleRepository;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class UsersServiceImpl implements UsersService {

    private final PeopleRepository peopleRepository;

    @Autowired
    public UsersServiceImpl(PeopleRepository peopleRepository) {
        this.peopleRepository = peopleRepository;
    }

    @Override
    public List<User> findAll() {
        return peopleRepository.findAll();
    }

    @Override
    public User findOne(int id) {
        Optional<User> foundPerson = peopleRepository.findById(id);
        return foundPerson.orElse(null);
    }

    @Transactional
    @Override
    public void save(User user) {
        peopleRepository.save(user);
    }

    @Transactional
    @Override
    public void update(int id, User userUpdate){
        userUpdate.setId(id);
        peopleRepository.save(userUpdate);
    }

    @Transactional
    @Override
    public void delete(int id){
        peopleRepository.deleteById(id);
    }

}
