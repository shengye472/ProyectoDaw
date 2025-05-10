package com.shopflow.domain.service;

import com.shopflow.domain.model.Users;

import java.util.Optional;

public interface UserService {
    Optional<Users> findByUserName(String username);
}
