package org.example.Models;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "apartment")
public class Apartment {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "address")
    private String address;

    @Column(name = "numberowner")
    private Integer numberowner;

    @Column(name = "owneremail")
    private String owneremail;

    @Column(name = "nameowner")
    private String nameowner;

    @Column(name ="name")
    private String name;

    @Column(name ="img")
    private String img;

    @OneToMany(mappedBy = "apartment", fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    private List<User> users;

    @OneToMany(mappedBy = "apartment", fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    private List<Task> tasks;

    public Apartment() {
    }

    public Apartment(int id, String address, int numberowner, String owneremail, String nameowner,String name,String img) {
        this.id = id;
        this.address = address;
        this.numberowner = numberowner;
        this.owneremail = owneremail;
        this.nameowner = nameowner;
        this.name = name;
        this.img = img;
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

    public String getName() { return name;}

    public void setName(String name) { this.name = name; }

    public String getImg() { return img;}

    public void setImg(String img) { this.img = img; }

    @Override
    public String toString() {
        return "Apartment{" +
                "id=" + id +
                ", address='" + address + '\'' +
                ", numberowner=" + numberowner +
                ", owneremail='" + owneremail + '\'' +
                ", nameowner='" + nameowner + '\'' +
                ", name='" + name + '\'' +
                ", img='" + img + '\'' +
                '}';
    }
}
