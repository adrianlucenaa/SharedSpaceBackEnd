package org.example.Controllers;

import java.util.List;

import org.example.Models.Apartment;
import org.example.service.ApartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/apartaments")
public class ApartmentController {

    @Autowired
    ApartmentService service;
    @GetMapping
    public ResponseEntity<List<Apartment>> getAllApartment(){
        List<Apartment> apartments = service.getAllApartments();
        return ResponseEntity.ok(apartments);
        //return new ResponseEntity<List<User>>(users, new HttpHeaders(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Apartment> getUserById(@PathVariable("id") int id){
        Apartment apartment = service.getApartmentById(id);
        return ResponseEntity.ok(apartment);
    }

    @PostMapping
    public ResponseEntity<Apartment> createOrUpdateApartment(@RequestBody Apartment apartment){
        Apartment end = service.createOrUpdateApartment(apartment);
        return ResponseEntity.ok(end);
    }

    @DeleteMapping("/{id}")
    public void deleteApartment(@PathVariable("id") int id){
        service.deleteApartment(id);
    }

}