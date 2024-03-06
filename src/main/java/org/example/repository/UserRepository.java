package org.example.repository;

import org.example.Models.Apartment;
import org.example.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {

    //Devuelve los usuarios de un apartamento poniendo el id de apartamento
    @Query(value = "SELECT * FROM users u WHERE u.id_apartment  = :Idapartment", nativeQuery = true)
    List<User> getUsersByApartmentId(@Param("Idapartment") int id);




    //Devuelve los usuarios por nombre de usuario
    @Query(value = "SELECT * FROM users u WHERE u.name = ?1", nativeQuery = true)
    List<User> getUsersByName(String name);

    //Devuelve los usuarios por nombre de apartamento
    /*
    @Query(value = "SELECT * FROM users u WHERE u.apartment_name = ?1", nativeQuery = true)
    List<User> getUsersByApartmentName(String name);


     */


    //Devuelve los usuarios que no tienen tareas completadass
    @Query(value = "SELECT * FROM users u WHERE u.id NOT IN (SELECT t.user_id FROM tasks t WHERE t.completed = false)", nativeQuery = true)
    List<User> getUsersTaskUncompleted();

}