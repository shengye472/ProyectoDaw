package com.shopflow.persistence.dao;

import com.shopflow.domain.model.Users;

import java.util.Optional;

public interface UserDao {
    Optional<Users> findByUsername(String username);
}
