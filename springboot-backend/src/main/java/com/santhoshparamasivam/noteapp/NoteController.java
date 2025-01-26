package com.santhoshparamasivam.noteapp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.*;
import java.util.Optional;

@RestController
public class NoteController {

    private final Logger logger = LoggerFactory.getLogger("NoteController");
    private final NoteRepository noteRepository;
    NoteController(NoteRepository noteRepository)
    {
        this.noteRepository = noteRepository;
    }

    @GetMapping("/hello")
    String sayHello()
    {
        return "Hello";
    }

    @GetMapping("/note")
    Note getNote()
    {
        Optional<Note> note = noteRepository.findByName("Santhosh");
        if(note.isEmpty())
        {
            logger.error("Empty result set");
            return new Note();
        }
        else
        {
            return note.get();
        }
    }

}
