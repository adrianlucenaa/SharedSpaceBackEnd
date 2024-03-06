package org.example.Models;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import org.springframework.data.annotation.Id;

@Entity
@Table(name = "tasks")
public class Task {

    @jakarta.persistence.Id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name", length = 256, nullable = false)
    private String name;

    @Column(name = "description", length = 256, nullable = false)
    private String description;

    @Column(name = "completed", nullable = false)
    private boolean completed;


    @ManyToOne(optional = true,fetch = FetchType.LAZY,cascade = CascadeType.MERGE)
    @JoinColumn(name = "apartment_id")
    private Apartment apartment;


    @ManyToOne(optional = true,fetch = FetchType.LAZY,cascade = CascadeType.MERGE)
    @JoinColumn(name = "user_id")
    private User user;

    public Task() {
    }




    public Task(int id, String name, String description, boolean completed, Apartment apartment, User user) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.completed = completed;
        this.apartment = apartment;
        this.user = user;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public Apartment getApartment() {
        return apartment;
    }

    public void setApartment(Apartment apartment) {
        this.apartment = apartment;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", completed=" + completed +
                ", apartment=" + apartment +
                ", user=" + user +
                '}';
    }

    public Task(String name, String description, boolean completed, Apartment apartment, User user) {
        this.name = name;
        this.description = description;
        this.completed = completed;
        this.apartment = apartment;
        this.user = user;
    }





}
