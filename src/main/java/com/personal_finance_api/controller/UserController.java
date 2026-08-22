package com.personal_finance_api.controller;

import com.personal_finance_api.dto.UserRequest;
import com.personal_finance_api.exception.BadRequestException;
import com.personal_finance_api.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createUser(@RequestBody UserRequest userRequest) throws BadRequestException {

        userService.createUser(userRequest);
    }
}
