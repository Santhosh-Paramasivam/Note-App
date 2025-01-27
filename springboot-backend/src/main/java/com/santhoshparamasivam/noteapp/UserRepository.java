package com.santhoshparamasivam.noteapp;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {
    @Query(value = "SELECT * from users WHERE id = :id", nativeQuery = true)
    Optional<User> getUserById(Integer id);
}
