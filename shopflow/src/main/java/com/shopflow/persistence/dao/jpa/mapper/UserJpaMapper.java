package com.shopflow.persistence.dao.jpa.mapper;

import com.shopflow.domain.model.Users;
import com.shopflow.persistence.dao.jpa.model.UserEntity;

public class UserJpaMapper {
    public static UserJpaMapper INSTANCE = new UserJpaMapper();

    public Users toUser(UserEntity userEntity) {
        Users user = new Users();
        user.setUsername(userEntity.getUsername());
        user.setPassword(userEntity.getPassword());
        user.setRol(getRol(userEntity.getRol()));
        return user;
    }

    private String getRol(Integer rol) {
        switch (rol) {
            case 1:
                return "CLIENT";
            default:
                return "UNKNOWN";
        }
    }
}
