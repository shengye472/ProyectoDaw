package com.shopflow.persistence.dao.jpa;

import com.shopflow.domain.model.Users;
import com.shopflow.persistence.dao.UserDao;
import com.shopflow.persistence.dao.jpa.mapper.UserJpaMapper;
import com.shopflow.persistence.dao.jpa.repository.UserJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class UserDaoImpl implements UserDao {

    @Autowired
    private UserJpaRepository userJpaRepository;

    @Override
    public Optional<Users> findByUsername(String username) {
        return userJpaRepository
                .findByUsername(username)
                .map(UserJpaMapper.INSTANCE::toUser);
    }
}
