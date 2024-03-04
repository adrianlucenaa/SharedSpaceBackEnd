package org.example.repository;
import org.example.Models.Apartment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface ApartmentRepository extends JpaRepository<Apartment, Integer> {

    List<Apartment> getApartmentsUncompleted();

    List<Apartment> getApartmentsByUserId(int id);

    List<Apartment> getApartmentsByName(String name);

    List<Apartment> getApartmentsByTask(int id);
}
