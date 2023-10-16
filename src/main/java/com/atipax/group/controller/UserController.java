package com.atipax.group.controller;

import com.atipax.group.model.User;
import com.atipax.group.model.entity.UserEntity;
import com.atipax.group.services.UserService;
import com.atipax.group.util.EncryptionData;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Base64;

@RequestMapping("/login")
@AllArgsConstructor
@RestController
public class UserController {

    private UserService service;

    @PostMapping("/user")
    public ResponseEntity<User> login (@RequestBody User user) throws Exception {
        User userValidate = service.login(user);
        return new ResponseEntity<>(userValidate, HttpStatus.OK);
    }

    @PostMapping("/register")
    public ResponseEntity<UserEntity> register(@RequestBody UserEntity userEntity) throws Exception {
        UserEntity user = service.registerUser(userEntity);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }
}
