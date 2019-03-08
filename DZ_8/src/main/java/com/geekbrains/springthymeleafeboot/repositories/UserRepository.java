package com.geekbrains.springthymeleafeboot.repositories;

import com.geekbrains.springthymeleafeboot.entities.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    User findOneByUserName(String userName);
}
