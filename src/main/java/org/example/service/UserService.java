package org.example.service;

import org.example.Models.User;
import org.example.exception.RecordNotFoundException;
import org.example.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    UserRepository repo;

    //Logica para devolver todos los usuarios
    public List<User> getAllUsers() {
        List<User> users =  repo.findAll();
        return users;
    }

    public User login(String usernameOrEmail, String password) {
        // Busca el usuario por su nombre de usuario o correo electrónico
        User user = repo.findByUsernameOrEmail(usernameOrEmail);

        // Verifica si el usuario existe y si la contraseña coincide
        if (user != null && user.getPassword().equals(password)) {
            return user; // La contraseña coincide, devuelve el usuario
        } else {
            return null; // La contraseña no coincide o el usuario no existe
        }
    }
    //Logica para buscar un usuario por id
    public User getUserById(int id) {
        Optional<User> user = repo.findById(id);
        if(user.isPresent()){
            return user.get();
        }else{
            throw new RecordNotFoundException("No user found with id: " + id);
        }
    }
    //Logica para crear o actualizar un usuario
    public User createOrUpdateUser(User user) {
        User end;
        if(user.getId() >0){ //update
            Optional<User> result = repo.findById(user.getId());
            if(result.isPresent()){
                User fromDB = result.get();
                fromDB.setName(user.getName());
                fromDB.setSurname(user.getSurname());
                fromDB.setEmail(user.getEmail());
                fromDB.setDni(user.getDni());
                fromDB.setPassword(user.getPassword());
                end=repo.save(fromDB);
            }else{
                throw new RecordNotFoundException("No user found with id: " + user.getId());
            }
        }else{  //insert
            end=repo.save(user);
        }
        return end;
    }

    //Logica para borrar un usuario
    public void deleteUser(int id) {
        Optional<User> result = repo.findById(id);
        if(result.isPresent()){
            repo.deleteById(id);
        }else{
            throw new RecordNotFoundException("No user found with id: " + id);
        }
    }

    //Devuelve todos los usuarios de un apartamento por id
    public List<User> getUsersByApartmentId(int id){
        return repo.getUsersByApartmentId(id);
    }



    //Devuelve todos los usuarios por nombre
    public List<User> getUsersByName(String name){
        return repo.getUsersByName(name);
    }

    //Devuelve los usuarios por nombre de apartamento
    public List<User> getUsersByApartmentName(String name){
        return repo.getUsersByApartmentName(name);
    }

    //Devuelve los usuarios que tengan asignadas tareas sin completar
    public List<User> getUsersTaskUncompleted() {
        return repo.getUsersTaskUncompleted();
    }

    //Devuelve los usuarios por id de tarea
    public List<User> getUsersByTaskId(int id) {
        return repo.getUsersByTaskId(id);
    }
}