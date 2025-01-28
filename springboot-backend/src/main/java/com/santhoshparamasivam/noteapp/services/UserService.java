package com.santhoshparamasivam.noteapp.services;

import com.santhoshparamasivam.noteapp.entities.User;
import com.santhoshparamasivam.noteapp.repositories.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class UserService {
    private final Logger logger = LoggerFactory.getLogger(UserService.class);
    private final UserRepository userRepository;

    UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Optional<User> getUserById(Integer id) {
        return this.userRepository.getUserById(id);
    }

    public Boolean isUsernameAvailable(String username) {
        Optional<User> user = this.userRepository.findByName(username);

        return user.isEmpty();
    }

    public void createUser(String username, String password) {
        User user = new User();
        user.setName(username);
        user.setPassword(password);
        this.userRepository.save(user);
    }

    public Integer authenticateUser(String username, String password)
    {
        Optional<User> user = this.userRepository.findByName(username);

        if(user.isPresent() && user.get().getPassword().equals(password))
        {
            return user.get().getId();
        }
        else
        {
            return -1;
        }
    }
}
