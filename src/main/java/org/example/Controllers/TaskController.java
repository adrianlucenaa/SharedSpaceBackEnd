package org.example.Controllers;

import org.example.Models.Apartment;
import org.example.Models.Task;
import org.example.Models.User;
import org.example.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    @Autowired
    TaskService service;

    //Devuelve todas las tareas
    @GetMapping
    public ResponseEntity<List<Task>> getAllTasks(){
        List<Task> tasks = service.getAllTasks();
        return ResponseEntity.ok(tasks);
    }

    //Devuelve todas las tareas por id
    @GetMapping("/{id}")
    public ResponseEntity<Task> getTaskById(@PathVariable("id") int id){
        Task task = service.getTaskById(id);
        return ResponseEntity.ok(task);
    }

    //Crea o actualiza una tarea
    @PostMapping
    public ResponseEntity<Task> createOrUpdateTask(@RequestBody Task task){
        Task end = service.createOrUpdateTask(task);
        return ResponseEntity.ok(end);
    }

    //Elimina una tarea
    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable("id") int id){
        service.deleteTask(id);
    }

    //Devuelve todas las tareas de un apartamento por id
    @GetMapping("/apartment/{id}")
    public ResponseEntity<List<Task>> getTasksByApartmentId(@PathVariable("id") int id){
        List<Task> tasks = service.getTasksByApartmentId(id);
        return ResponseEntity.ok(tasks);
    }

    //Devuelve todas las tareas de un usuario por id
    @GetMapping("/user/{id}")
    public ResponseEntity<List<Task>> getTasksByUserId(@PathVariable("id") int id){
        List<Task> tasks = service.getTasksByUserId(id);
        return ResponseEntity.ok(tasks);
    }

    //Devuelve todas las tareas de un apartamento y un usuario
    @GetMapping("/apartment/{id}/user/{id2}")
    public ResponseEntity<List<Task>> getTasksByApartmentIdAndUserId(@PathVariable("id") int id, @PathVariable("id2") int id2){
        List<Task> tasks = service.getTasksByApartmentIdAndUserId(id, id2);
        return ResponseEntity.ok(tasks);
    }


    //Devuelve todas las tareas de un usuario por nombre de usuario
    @GetMapping("/user/name/{name}")
    public ResponseEntity<List<Task>> getTasksByUserName(@PathVariable("name") String name){
        List<Task> tasks = service.getTasksByUserName(name);
        return ResponseEntity.ok(tasks);
    }
}