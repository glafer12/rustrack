package com.nga.structura.controller;

import com.fasterxml.jackson.annotation.JsonView;
import com.nga.structura.dto.UserDTO;
import com.nga.structura.model.Task;
import com.nga.structura.model.User;
import com.nga.structura.service.UserService;
import com.nga.structura.views.Views;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    private UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    @Operation(summary = "Получить всех пользователей")
    public List<UserDTO> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Получить пользователя по id")
    public Optional<UserDTO> getUserById(@PathVariable Long id) {
        return userService.getUserById(id);
    }

    @PostMapping
    @Operation(summary = "Создать нового пользователя")
    public UserDTO createUser(@RequestBody UserDTO userDTO) {
        return userService.createUser(userDTO);
    }

}
