package com.shopflow.persistence.dao.jpa.repository;

import com.shopflow.persistence.dao.jpa.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserJpaRepository extends JpaRepository<UserEntity, Integer> {
    Optional<UserEntity> findByUsername(String username);
}
