package org.example.Models;

public class Task {

    private int id;
    private String name;
    private String description;
    private boolean completed;
    private Apartment apartment;
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

    @java.lang.Override
    public java.lang.String toString() {
        return "Task{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", completed=" + completed +
                ", apartment=" + apartment +
                ", user=" + user +
                '}';
    }
}
