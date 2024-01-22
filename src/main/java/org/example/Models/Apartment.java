package org.example.Models;


import jakarta.persistence.*;

@Entity
@Table(name = "apartment")
public class Apartment {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "address", length=256, nullable = false)
    private String address;

    @Column(name = "numberowner", nullable = false)
    private Integer numberowner;

    @Column(name = "owneremail", length=256, nullable = false)
    private String owneremail;

    @Column(name = "nameowner", length=256, nullable = false)
    private String nameowner;

    public Apartment() {
    }

    public Apartment(int id, String address, int numberowner, String owneremail) {
        this.id = id;
        this.address = address;
        this.numberowner = numberowner;
        this.owneremail = owneremail;
        this.nameowner = nameowner;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getNumberowner() {
        return numberowner;
    }

    public void setNumberowner(Integer numberowner) {
        this.numberowner = numberowner;
    }

    public String getOwneremail() {
        return owneremail;
    }

    public void setOwneremail(String owneremail) {
        this.owneremail = owneremail;
    }

    public String getNameowner() {
        return nameowner;
    }

    public void setNameowner(String nameowner) {
        this.nameowner = nameowner;
    }

    @Override
    public String toString() {
        return "Apartment{" +
                "id=" + id +
                ", address='" + address + '\'' +
                ", numberowner=" + numberowner +
                ", owneremail='" + owneremail + '\'' +
                ", nameowner='" + nameowner + '\'' +
                '}';
    }
}
