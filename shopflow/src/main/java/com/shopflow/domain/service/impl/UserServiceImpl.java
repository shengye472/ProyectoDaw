package com.shopflow.domain.service.impl;

import com.shopflow.common.annotation.DomainService;
import com.shopflow.domain.model.Users;
import com.shopflow.domain.repository.UserRepository;
import com.shopflow.domain.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

@DomainService
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public Optional<Users> findByUserName(String username) {
        return userRepository.findByUserName(username);
    }
}
