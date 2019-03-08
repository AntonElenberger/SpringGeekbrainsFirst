package com.geekbrains.springthymeleafeboot.repositories;

import com.geekbrains.springthymeleafeboot.entities.Role;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends CrudRepository<Role, Long> {
    Role findOneByName(String roleName);
}
