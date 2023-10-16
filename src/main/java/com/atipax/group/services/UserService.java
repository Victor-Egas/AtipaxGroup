package com.atipax.group.services;

import com.atipax.group.model.User;
import com.atipax.group.model.entity.UserEntity;

public interface UserService {

    UserEntity registerUser(UserEntity user) throws Exception;

    User login(User user) throws Exception;
}
