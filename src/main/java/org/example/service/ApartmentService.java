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

    public List<Apartment> getAllApartments() {
        return apartmentRepository.findAll();
    }

    public Apartment getApartmentById(int id) {
        Optional<Apartment> apartment = apartmentRepository.findById(id);
        if (apartment.isPresent()) {
            return apartment.get();
        } else {
            throw new RecordNotFoundException("No apartment found with id: " + id);
        }
    }

    public Apartment createOrUpdateApartment(Apartment apartment) {
        Apartment result;
        if (apartment.getId() != 0) {
            Optional<Apartment> resultOptional = apartmentRepository.findById(apartment.getId());
            if (resultOptional.isPresent()) {
                Apartment fromDB = resultOptional.get();
                fromDB.setAddress(apartment.getAddress());
                fromDB.setNumberowner(apartment.getNumberowner());
                fromDB.setOwneremail(apartment.getOwneremail());
                result = apartmentRepository.save(fromDB);
            } else {
                throw new RecordNotFoundException("No apartment found with id: " + apartment.getId());
            }
        } else {  //insert
            result = apartmentRepository.save(apartment);
        }
        return result;
    }

    public void deleteApartment(int id) {
        Optional<Apartment> resultOptional = apartmentRepository.findById(id);
        if (resultOptional.isPresent()) {
            apartmentRepository.deleteById(id);
        } else {
            throw new RecordNotFoundException("No apartment found with id: " + id);
        }
    }
}