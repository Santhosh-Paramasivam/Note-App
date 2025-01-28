package com.santhoshparamasivam.noteapp.repositories;

import com.santhoshparamasivam.noteapp.entities.Note;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface NoteRepository extends JpaRepository<Note, Integer>
{
    Optional<Note> findByName(String name);

    @Query(value = "SELECT * FROM notes WHERE user_id = :userId", nativeQuery = true)
    List<Note> getAllNotesForUser(Integer userId);
}