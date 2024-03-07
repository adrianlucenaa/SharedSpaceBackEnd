package org.example.service;

import org.example.Models.Apartment;
import org.example.exception.RecordNotFoundException;
import org.example.repository.ApartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ApartmentService {

    @Autowired
    private ApartmentRepository apartmentRepository;

    //Logica devueve todas las apartamentos
    public List<Apartment> getAllApartments() {
        return apartmentRepository.findAll();
    }

    //Logica para buscar un apartamento por id
    public Apartment getApartmentById(int id) {
        Optional<Apartment> apartment = apartmentRepository.findById(id);
        if (apartment.isPresent()) {
            return apartment.get();
        } else {
            throw new RecordNotFoundException("No apartment found with id: " + id);
        }
    }


    public Apartment updateApartment(Integer apartmentId, Apartment apartment) {
        // Verificar si el apartamento existe en la base de datos
        Apartment existingApartment = apartmentRepository.findById(apartmentId).orElse(null);
        if (existingApartment != null) {
            // Actualizar los campos del apartamento existente con los valores del apartamento recibido
            existingApartment.setAddress(apartment.getAddress());
            existingApartment.setNumberowner(apartment.getNumberowner());
            existingApartment.setOwneremail(apartment.getOwneremail());
            existingApartment.setNameowner(apartment.getNameowner());
            existingApartment.setName(apartment.getName());
            existingApartment.setImg(apartment.getImg());
            // Guardar los cambios en la base de datos y devolver el apartamento actualizado
            return apartmentRepository.save(existingApartment);
        } else {
            // El apartamento no existe en la base de datos
            throw new IllegalArgumentException("Apartment not found");
        }
    }


    //Logica para crear o actualizar un apartamento
    public Apartment createOrUpdateApartment(Apartment apartment) {
        Apartment result;
        if (apartment.getId() != 0) {
            Optional<Apartment> resultOptional = apartmentRepository.findById(apartment.getId());
            if (resultOptional.isPresent()) {
                Apartment fromDB = resultOptional.get();
                fromDB.setAddress(apartment.getAddress());
                fromDB.setNumberowner(apartment.getNumberowner());
                fromDB.setOwneremail(apartment.getOwneremail());
                fromDB.setNameowner(apartment.getNameowner());
                result = apartmentRepository.save(fromDB);
            } else {
                throw new RecordNotFoundException("No apartment found with id: " + apartment.getId());
            }
        } else {  //insert
            result = apartmentRepository.save(apartment);
        }
        return result;
    }



    //Logica para borrar un apartamento
    public void deleteApartment(int id) {
        Optional<Apartment> resultOptional = apartmentRepository.findById(id);
        if (resultOptional.isPresent()) {
            apartmentRepository.deleteById(id);
        } else {
            throw new RecordNotFoundException("No apartment found with id: " + id);
        }
    }



    //Devuelve todos los apartamentos por nombre
    public List<Apartment> getApartmentsByName(String name){
        return apartmentRepository.getApartmentsByName(name);
    }



    //Devuelve todos los apartamentos de una tarea
    public List<Apartment> getApartmentsByTask(int id){
        return apartmentRepository.getApartmentsByTask(id);

    }

    //Devuelve todos los apartamentos con tareas sin completar
    public List<Apartment> getApartmentsUncompleted() {
        return apartmentRepository.getApartmentsUncompleted();
    }
}