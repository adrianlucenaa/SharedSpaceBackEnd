package org.example.repository;
import org.example.Models.Apartment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface ApartmentRepository extends JpaRepository<Apartment, Integer> {

    @Query(value = "SELECT a.* FROM apartments a JOIN tasks t ON a.id = t.apartment_id WHERE t.completed = false", nativeQuery = true)
    List<Apartment> getApartmentsUncompleted();

    @Query(value = "SELECT * FROM apartments a WHERE a.numnberowner=?1", nativeQuery = true)
    List<Apartment> getApartmentsByUserId(@Param("id") int id);


    //Devuelve los apartamentos por nombre de apartamento
    @Query(value = "SELECT * FROM apartments a WHERE a.name=?1", nativeQuery = true)
    List<Apartment> getApartmentsByName(String name);

    //Devuelve todos los apatmentos por tarea id
    @Query(value = "SELECT a.* FROM apartments a JOIN tasks t ON a.id = t.apartment_id WHERE t.id = ?1", nativeQuery = true)
    List<Apartment> getApartmentsByTask(int id);
}
