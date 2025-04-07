package com.nga.structura.controller;

import com.nga.structura.dto.UserDTO;
import com.nga.structura.model.Task;
import com.nga.structura.model.User;
import com.nga.structura.service.UserService;
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
    public List<UserDTO> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    public Optional<UserDTO> getUserById(@PathVariable Long id) {
        return userService.getUserById(id);
    }

    @PostMapping
    public UserDTO createUser(@RequestBody UserDTO userDTO) {
        return userService.createUser(userDTO);
    }

}
