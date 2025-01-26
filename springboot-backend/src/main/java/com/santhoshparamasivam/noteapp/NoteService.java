package com.santhoshparamasivam.noteapp;

import org.springframework.stereotype.Service;

@Service
public class NoteService {
    private NoteRepository noteRepository;
    NoteService(NoteRepository noteRepository)
    {
        this.noteRepository = noteRepository;
    }


}
