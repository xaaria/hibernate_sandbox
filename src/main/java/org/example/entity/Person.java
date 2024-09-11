package org.example.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table
public class Person {

    @Id
    @GeneratedValue
    private Long id;

    private String firstname;


    private String lastname;

    // Person lives in these houses
    @ManyToMany
    @JoinTable(name="HOUSE_RESIDENTS",
        joinColumns=@JoinColumn(name="PERSON_ID"),
        inverseJoinColumns=@JoinColumn(name="HOUSE_ID")
    )
    private Set<House> houses = new HashSet<>();
    //

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    //

    public Person() {

    }

    @Override
    public String toString() {
        return String.format("<Person (%f)>", this.getId());
    }

}
