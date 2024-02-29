package org.example.Controllers;

import org.example.Models.User;
import org.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    UserService service;
    //Devuelve todos los usuarios
    @GetMapping
    public ResponseEntity<List<User>> getAllUsers(){
        List<User> users = service.getAllUsers();
        return ResponseEntity.ok(users);

    }

    //Devuelve un usuario por id
    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable("id") int id){
        User user = service.getUserById(id);
        return ResponseEntity.ok(user);
    }

    //Crea o actualiza un usuario
    @PostMapping
    public ResponseEntity<User> createOrUpdateUser(@RequestBody User user){
        User end = service.createOrUpdateUser(user);
        return ResponseEntity.ok(end);
    }

    //Elimina un usuario
    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable("id") int id){
        service.deleteUser(id);
    }

    //Devuelve todos los usuarios por nombre
    @GetMapping("/name/{name}")
    public ResponseEntity<List<User>> getUsersByName(@PathVariable("name") String name){
        List<User> users = service.getUsersByName(name);
        return ResponseEntity.ok(users);
    }

    //Devuelve todos los Usuarios por apartamento id
    @GetMapping("/apartment/{id}")
    public ResponseEntity<List<User>> getUsersByApartmentId(@PathVariable("id") int id){
        List<User> users = service.getUsersByApartmentId(id);
        return ResponseEntity.ok(users);
    }

    //Devuelve los usuarioas que tengan asignadas tareas sin completar
    @GetMapping("/user/task/uncompleted")
    public ResponseEntity<List<User>> getUsersUncompleted(){
        List<User> users = service.getUsersUncompleted();
        return ResponseEntity.ok(users);
    }

    //Devuelve los usuarios por nombre de apartamento
    @GetMapping("/apartment/name/{name}")
    public ResponseEntity<List<User>> getUsersByApartmentName(@PathVariable("name") String name){
        List<User> users = service.getUsersByApartmentName(name);
        return ResponseEntity.ok(users);
    }

}