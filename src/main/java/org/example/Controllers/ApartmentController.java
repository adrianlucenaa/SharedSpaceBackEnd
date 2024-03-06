package org.example.Controllers;

import java.util.List;

import org.example.Models.Apartment;
import org.example.service.ApartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/apartments")
public class ApartmentController {

    @Autowired
    ApartmentService service;

    //Devuelve todos los apartamentos
    @GetMapping
    public ResponseEntity<List<Apartment>> getAllApartment(){
        List<Apartment> apartments = service.getAllApartments();
        return ResponseEntity.ok(apartments);
        //return new ResponseEntity<List<User>>(users, new HttpHeaders(), HttpStatus.OK);
    }

    //Devuelve todos los apartamentos por id
    @GetMapping("/{id}")
    public ResponseEntity<Apartment> getUserById(@PathVariable("id") int id){
        Apartment apartment = service.getApartmentById(id);
        return ResponseEntity.ok(apartment);
    }

    //Crea o actualiza un apartamento
    @PostMapping
    public ResponseEntity<Apartment> createOrUpdateApartment(@RequestBody Apartment apartment){
        Apartment end = service.createOrUpdateApartment(apartment);
        return ResponseEntity.ok(end);
    }

    //Elimina un apartamento
    @DeleteMapping("/{id}")
    public void deleteApartment(@PathVariable("id") int id){
        service.deleteApartment(id);
    }



    //Devuelve todos los apartamentos por nombre de apartamento
    @GetMapping("/name/{name}")
    public ResponseEntity<List<Apartment>> getApartmentsByName(@PathVariable("name") String name){
        List<Apartment> apartments = service.getApartmentsByName(name);
        return ResponseEntity.ok(apartments);
    }

    //Devuelve todos los apartamentos con tareas sin completar
    @GetMapping("/task/uncompleted")
    public ResponseEntity<List<Apartment>> getApartmentUncompleted(){
        List<Apartment> apartments = service.getApartmentsUncompleted();
        return ResponseEntity.ok(apartments);
    }

}