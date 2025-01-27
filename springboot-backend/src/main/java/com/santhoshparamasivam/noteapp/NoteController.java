package com.santhoshparamasivam.noteapp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.sql.*;
import java.util.List;
import java.util.Optional;

@RestController
public class NoteController {

    private final Logger logger = LoggerFactory.getLogger(NoteController.class);
    private final NoteService noteService;
    private final UserService userService;
    NoteController(NoteService noteService, UserService userService)
    {
        this.noteService = noteService;
        this.userService = userService;
    }

    @GetMapping("/note")
    List<Note> getNotesOfUser(@RequestParam Integer userId)
    {
        return noteService.getAllNotesForUser(userId);
    }

    @GetMapping("/user")
    public ResponseEntity<User> getUserById(@RequestParam Integer id) {
        Optional<User> user = userService.getUserById(id);
        if (user.isPresent()) {
            logger.info("User found: " + user.get().getName());
            return ResponseEntity.ok(user.get());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }
}
