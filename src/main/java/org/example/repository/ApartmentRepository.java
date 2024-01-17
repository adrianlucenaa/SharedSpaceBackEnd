package org.example.repository;
import org.example.Models.Apartment;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ApartmentRepository extends JpaRepository<Apartment, Integer> {
}
