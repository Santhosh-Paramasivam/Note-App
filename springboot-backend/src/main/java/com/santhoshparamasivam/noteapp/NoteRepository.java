package com.santhoshparamasivam.noteapp;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface NoteRepository extends JpaRepository<Note, Integer>
{
    Optional<Note> findByName(String name);
}