package org.example.repository;

import org.example.Models.Apartment;
import org.example.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Integer> {
    List<User> getUsersByApartmentId(int id);

    List<User> getUsersByTaskId(int id);


    List<User> getUsersByName(String name);


    List<User> getUsersByApartmentName(String name);

    List<User> getUsersTaskUncompleted();
}