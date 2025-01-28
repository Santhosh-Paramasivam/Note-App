package com.santhoshparamasivam.noteapp.services;

import com.santhoshparamasivam.noteapp.entities.Note;
import com.santhoshparamasivam.noteapp.repositories.NoteRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoteService {
    private final NoteRepository noteRepository;
    NoteService(NoteRepository noteRepository)
    {
        this.noteRepository = noteRepository;
    }

    public List<Note> getAllNotesForUser(Integer userID)
    {
        return this.noteRepository.getAllNotesForUser(userID);
    }

    public void saveNote(Note note)
    {
        this.noteRepository.save(note);
    }
}
