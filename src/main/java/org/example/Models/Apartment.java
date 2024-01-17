package org.example.Models;


import jakarta.persistence.*;

@Entity
@Table(name = "apartment")
public class Apartment {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "address", length=256, nullable = false)
    private String address;

    @Column(name = "numberowner", nullable = false)
    private int numberowner;

    @Column(name = "owneremail", length=256, nullable = false)
    private String owneremail;

    public Apartment() {
    }

    public Apartment(int id, String address, int numberowner, String owneremail) {
        this.id = id;
        this.address = address;
        this.numberowner = numberowner;
        this.owneremail = owneremail;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getNumberowner() {
        return numberowner;
    }

    public void setNumberowner(int numberowner) {
        this.numberowner = numberowner;
    }

    public String getOwneremail() {
        return owneremail;
    }

    public void setOwneremail(String owneremail) {
        this.owneremail = owneremail;
    }

    @Override
    public String toString() {
        return "Apartment{" +
                "id=" + id +
                ", address='" + address + '\'' +
                ", numberowner=" + numberowner +
                ", owneremail='" + owneremail + '\'' +
                '}';
    }

}
