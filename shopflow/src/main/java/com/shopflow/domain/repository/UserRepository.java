package com.shopflow.domain.repository;

import com.shopflow.domain.model.Users;

import java.util.Optional;

public interface UserRepository {
    Optional<Users> findByUserName(String username);
}
