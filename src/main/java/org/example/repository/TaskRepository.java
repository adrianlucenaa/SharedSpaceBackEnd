package org.example.repository;

import org.example.Models.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Integer> {

    //Devuelve las tareas por apartamento
    @Query(value = "SELECT * FROM tasks t WHERE t.apartment_id = ?1", nativeQuery = true)
    List<Task> getTasksByApartmentId(int id);

    //Devuelve las tareas por usuario
    @Query(value = "SELECT * FROM tasks t WHERE t.user_id = ?1", nativeQuery = true)
    List<Task> getTasksByUserId(int id);

    //Devuelve las tareas por apartamento y usuario
    @Query(value = "SELECT * FROM tasks t WHERE t.apartment_id = ?1 AND t.user_id = ?2", nativeQuery = true)
    List<Task> getTasksByApartmentIdAndUserId(int id1, int id2);

    //Devuelve las tareas por nombre de usuario
    @Query(value = "SELECT * FROM tasks t WHERE t.user_name = ?1", nativeQuery = true)
    List<Task> getTasksByUserName(String name);

    //Crea una tarea por apartamento
    @Query(value = "INSERT INTO tasks (name, description, completed, apartment_id, user_id, user_name) VALUES (?1, ?2, ?3, ?4, ?5, ?6)", nativeQuery = true)
    void createTaskByApartmentId(int id, String name, String description, boolean completed, int apartment_id, int user_id, String user_name);
}