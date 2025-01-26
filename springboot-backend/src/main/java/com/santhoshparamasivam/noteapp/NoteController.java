package com.santhoshparamasivam.noteapp;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.*;

@RestController
public class NoteController {
    @GetMapping("/")
    String sayHello()
    {
        return "Hello";
    }

}
