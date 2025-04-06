package com.nga.structura.service;

import com.nga.structura.model.Task;
import com.nga.structura.model.User;
import com.nga.structura.repository.TaskRepository;
import com.nga.structura.repository.UserRepository;

import java.util.List;
import java.util.Optional;

public class UserService {

    private final UserRepository userRepository;

    public UserService (UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAllTasks() {
        return userRepository.findAll();
    }

    public Optional<User> getTaskById(Long id) {
        return userRepository.findById(id);
    }

    public User createUser(User user) {
        return userRepository.save(user);
    }

}
