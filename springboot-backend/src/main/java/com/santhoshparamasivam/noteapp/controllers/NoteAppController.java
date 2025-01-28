package com.santhoshparamasivam.noteapp.controllers;

import com.santhoshparamasivam.noteapp.services.NoteService;
import com.santhoshparamasivam.noteapp.services.UserService;
import com.santhoshparamasivam.noteapp.entities.Note;
import com.santhoshparamasivam.noteapp.entities.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class NoteAppController {

    private final Logger logger = LoggerFactory.getLogger(NoteAppController.class);
    private final NoteService noteService;
    private final UserService userService;
    NoteAppController(NoteService noteService, UserService userService)
    {
        this.noteService = noteService;
        this.userService = userService;
    }

    @GetMapping("/get-notes")
    List<Note> getNotesOfUser(@RequestParam Integer userId)
    {
        return noteService.getAllNotesForUser(userId);
    }

    @GetMapping("/user")
    public ResponseEntity<User> getUserById(@RequestParam Integer id) {
        Optional<User> user = userService.getUserById(id);
        if (user.isPresent()) {
            logger.debug("User found: " + user.get().getName());
            return ResponseEntity.ok(user.get());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @PostMapping("/adduser")
    public void createUser(@RequestParam String username, @RequestParam String password) {
        logger.debug(username + " " +password);
        if(userService.isUsernameAvailable(username))
        {
            userService.createUser(username, password);
        }
        else
        {
            logger.info("Username taken");
        }
    }

    @GetMapping("/authuser")
    public Integer authenticateUser(@RequestParam String username, @RequestParam String password)
    {
        logger.debug(username + " " + password);
        Integer userId = this.userService.authenticateUser(username, password);

        if(userId != -1)
        {
            return userId;
        }
        else
        {
            return null;
        }
    }

}
