package com.santhoshparamasivam.noteapp;

import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class UserService {
    private final UserRepository userRepository;

    UserService(UserRepository userRepository)
    {
        this.userRepository = userRepository;
    }

    Optional<User> getUserById(Integer id)
    {
        return this.userRepository.getUserById(id);
    }
}
