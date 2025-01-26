package com.santhoshparamasivam.noteapp;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoteService {
    private final NoteRepository noteRepository;
    NoteService(NoteRepository noteRepository)
    {
        this.noteRepository = noteRepository;
    }

    List<Note> getAllNotesForUser(Integer userID)
    {
        return this.noteRepository.getAllNotesForUser(userID);
    }
}
