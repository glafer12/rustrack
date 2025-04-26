package com.nga.structura.repository;

import com.nga.structura.model.User;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {

    List<User> findByLastNameContainingIgnoreCase(String lastName);

}