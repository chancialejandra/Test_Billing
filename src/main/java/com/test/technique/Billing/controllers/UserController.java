package com.test.technique.Billing.controllers;

import com.test.technique.Billing.dto.Request.UserRequest;
import com.test.technique.Billing.services.interfaces.IUserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("billing/user")
public class UserController {

    private final IUserService userService;

    public UserController(IUserService userService) {
        this.userService = userService;
    }
    @PostMapping
    public ResponseEntity<?> createUser(@RequestBody UserRequest user){
        var response = userService.createUser(user);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
}
