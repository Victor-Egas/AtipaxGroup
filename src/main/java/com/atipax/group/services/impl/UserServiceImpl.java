package com.atipax.group.services.impl;

import com.atipax.group.model.User;
import com.atipax.group.model.entity.UserEntity;
import com.atipax.group.repository.UserRepository;
import com.atipax.group.services.UserService;
import com.atipax.group.util.EncryptionData;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

@AllArgsConstructor
@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    @Override
    public UserEntity registerUser(UserEntity user) throws Exception {
        String passwordEncryptor = Base64.getEncoder()
                .encodeToString(EncryptionData.messageEncryption(user.getUserPassword()));
        user.setUserPassword(passwordEncryptor);
        return userRepository.save(user);
    }

    /**
     * @param user
     * @return
     */
    @Override
    public User login(User user) throws Exception {
        UserEntity userEntity = userRepository.login(user.getUser());
        String passwordDecryptor = EncryptionData.messageDecryptor(userEntity.getUserPassword()
                .getBytes(StandardCharsets.UTF_8));

        return passwordDecryptor.equalsIgnoreCase(user.getPassword())
                ? user
                : new User();
    }
}
