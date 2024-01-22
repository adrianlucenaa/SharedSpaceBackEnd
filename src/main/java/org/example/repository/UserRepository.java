package org.example.repository;

import org.example.Models.Apartment;
import org.example.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}