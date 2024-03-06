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
    @JoinColumn(name = "id_apartment")
    @JsonIgnoreProperties("apartment")
    private Apartment apartment;


    @ManyToOne(optional = true,fetch = FetchType.LAZY,cascade = CascadeType.MERGE)
    @JoinColumn(name = "id_user")
    @JsonIgnoreProperties("user")
    private User user;

    public Task() {
    }




    public Task(String name, String description, boolean completed, int apartmentId, int userId) {
        this.name = name;
        this.description = description;
        this.completed = completed;
        this.apartment.setId(apartmentId);
        this.user.setId(userId);
    }

    public void setApartmentId(int apartmentId) {
        this.apartment = new Apartment();
        this.apartment.setId(apartmentId);
    }

    public void setUserId(int userId) {
        this.user = new User();
        this.user.setId(userId);
    }

    public int getApartmentId() {
        this.apartment.getId();
        return 0;
    }

    public int getUserId() {
        this.user.getId();
        return 0;
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



    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", completed=" + completed +
                ", apartmentId=" + apartment +
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
