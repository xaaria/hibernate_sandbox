package org.example.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.ColumnDefault;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table
public class Person {

    @Id
    @GeneratedValue
    private Long id;

    private String firstname;

    private String lastname;

    // 0=unkown, 1=female, 2=male
    // TODO: use enum and add validator?
    @Column(name="gender", nullable=false) // just testing no real need to use
    @ColumnDefault("1")
    private Integer sex;

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

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public Set<House> getHouses() {
        return houses;
    }

    public void setHouses(Set<House> houses) {
        this.houses = houses;
    }

    //

    public Person() {

    }

    @Override
    public String toString() {
        return String.format("<Person (%f)>", this.getId());
    }


}
