package com.atipax.group.mapper;

import com.atipax.group.model.User;
import com.atipax.group.model.entity.UserEntity;

public class UserMapper {

    public static User userEntityToUser(UserEntity userEntity){
        return User.builder()
                .user(userEntity.getUserLogin())
                .password(userEntity.getUserPassword())
                .name(userEntity.getName())
                .build();
    }
}
