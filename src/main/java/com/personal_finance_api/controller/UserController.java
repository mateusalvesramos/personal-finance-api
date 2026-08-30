package com.personal_finance_api.controller;

import com.personal_finance_api.database.model.UserEntity;
import com.personal_finance_api.dto.UserRequest;
import com.personal_finance_api.dto.UserResponse;
import com.personal_finance_api.exception.BadRequestException;
import com.personal_finance_api.exception.NotFoundException;
import com.personal_finance_api.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<UserResponse> findAllUsers() {

        return userService.findAllUsers();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public UserResponse findUserById(@PathVariable("id") Integer id) throws NotFoundException {

        return userService.findUserById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createUser(@Valid @RequestBody UserRequest userRequest) throws BadRequestException {

        userService.createUser(userRequest);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteUser(@PathVariable("id") Integer id) throws NotFoundException{

        userService.deleteUserById(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void updateUser(@PathVariable("id") Integer id, @RequestBody UserRequest user) throws NotFoundException {

        userService.updateUser(id, user);
    }
}
