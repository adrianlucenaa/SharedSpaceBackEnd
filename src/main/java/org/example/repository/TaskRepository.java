package org.example.repository;

import org.example.Models.Task;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Integer> {

    List<Task> getTasksByApartmentId(int id);

    List<Task> getTasksByUserId(int id);

    List<Task> getTasksByApartmentIdAndUserId(int id1, int id2);
}