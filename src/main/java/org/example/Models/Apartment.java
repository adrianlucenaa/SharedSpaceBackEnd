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

    @Column(name ="name", length=256,nullable = false )
    private String name;

    @Column(name ="img", length=256,nullable = false)
    private String img;

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
