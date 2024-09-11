package org.example.entity;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

import static jakarta.persistence.GenerationType.UUID;

@Entity
@Table
public class House {

    @Id
    @GeneratedValue(strategy = UUID)
    private String uuid;

    @Column(nullable = false)
    private String address;

    @Column(nullable = false)
    private Integer number;

    @ManyToMany(mappedBy = "houses")
    private Set<Person> residents = new HashSet<>();

    //

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public Set<Person> getResidents() {
        return residents;
    }

    public void setResidents(Set<Person> residents) {
        this.residents = residents;
    }

    //

    public House() {

    }

    public House(
            String address,
            Integer number
    ) {
        this.setAddress(address);
        this.setNumber(number);
    }



}
