package com.geekbrains.springthymeleafeboot.services;

import com.geekbrains.springthymeleafeboot.entities.SystemUser;
import com.geekbrains.springthymeleafeboot.entities.User;
import org.springframework.security.core.userdetails.UserDetailsService;



public interface UserService extends UserDetailsService {
    User findByUserName(String username);
    boolean save(SystemUser systemUser);
}
