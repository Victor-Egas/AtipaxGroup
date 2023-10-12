package com.atipax.group.controller;

import com.atipax.group.model.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/login")
@RestController
public class UserController {

    @PostMapping("/user")
    public ResponseEntity<Boolean> login (@RequestBody User user) {
        boolean response = user.getCode() == 1 ? true : false;
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
