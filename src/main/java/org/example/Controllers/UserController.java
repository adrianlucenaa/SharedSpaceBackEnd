package org.example.Controllers;

import org.example.Models.LoginRequest;
import org.example.Models.User;
import org.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@CrossOrigin(origins = "http://localhost:8100")
public class UserController {
    @Autowired
    UserService service;
    //Devuelve todos los usuarios
    @GetMapping
    public ResponseEntity<List<User>> getAllUsers(){
        List<User> users = service.getAllUsers();
        return ResponseEntity.ok(users);

    }

    @PostMapping("/login")
    public ResponseEntity<User> login(@RequestBody LoginRequest loginRequest) {
        // Obtener el usuario basado en el nombre de usuario o email proporcionado
        User user = service.login(loginRequest.getUsernameOrEmail(), loginRequest.getPassword());

        if (user == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build(); // Usuario no encontrado o contraseña incorrecta
        }

        // Devolver el usuario autenticado
        return ResponseEntity.ok(user);
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

    //Devuelve los usuarios que tengan asignadas tareas sin completar
    @GetMapping("/user/task/uncompleted")
    public ResponseEntity<List<User>> getUsersTaskUncompleted(){
        List<User> users = service.getUsersTaskUncompleted();
        return ResponseEntity.ok(users);
    }

}