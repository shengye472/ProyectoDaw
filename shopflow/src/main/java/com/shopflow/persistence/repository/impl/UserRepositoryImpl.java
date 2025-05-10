package com.shopflow.persistence.repository.impl;

import com.shopflow.domain.model.Users;
import com.shopflow.domain.repository.UserRepository;
import com.shopflow.persistence.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class UserRepositoryImpl implements UserRepository {

    @Autowired
    private UserDao userDao;

    @Override
    public Optional<Users> findByUserName(String username) {
        return userDao.findByUsername(username);
    }
}
