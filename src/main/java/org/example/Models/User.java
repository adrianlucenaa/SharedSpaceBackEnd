package org.example.Models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name", length = 256, nullable = false)
    private String name;

    @Column(name = "surname", length = 256, nullable = false)
    private String surname;

    @Column(name = "email", length = 256, nullable = false)
    private String email;

    @Column(name = "password", length = 256, nullable = false)
    private String password;

    @Column(name = "dni", length = 256, nullable = false)
    private String dni;



    @ManyToOne(optional = true,fetch = FetchType.LAZY,cascade = CascadeType.MERGE)
    @JoinColumn(name = "id_apartment")
    private Apartment apartment;

    public User() {
    }

    public User(Integer id, String name, String surname, String email, String password, String dni, Apartment apartment) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.password = password;
        this.dni = dni;
        this.apartment = apartment;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public Apartment getApartment() {
        return apartment;
    }

    public void setApartment(Apartment apartment) {
        this.apartment = apartment;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", dni='" + dni + '\'' +
                ", apartment=" + apartment +
                '}';
    }
}