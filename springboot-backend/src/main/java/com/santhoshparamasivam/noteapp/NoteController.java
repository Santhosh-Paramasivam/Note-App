package com.santhoshparamasivam.noteapp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
    NoteController(NoteService noteService)
    {
        this.noteService = noteService;
    }

    @GetMapping("/note")
    List<Note> getNotesOfUser(@RequestParam Integer userId)
    {
        return noteService.getAllNotesForUser(userId);
    }


}
