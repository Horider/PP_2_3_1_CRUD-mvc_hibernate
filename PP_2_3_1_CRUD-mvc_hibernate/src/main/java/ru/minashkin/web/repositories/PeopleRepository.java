package ru.minashkin.web.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.minashkin.web.models.User;

@Repository
public interface PeopleRepository extends JpaRepository <User, Integer>{
}
