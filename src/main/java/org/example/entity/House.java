package org.example.entity;

import jakarta.persistence.*;

import static jakarta.persistence.GenerationType.UUID;

@Entity
@Table
public class House {

    @Id
    @GeneratedValue(strategy = UUID)
    private String uuid;

    @Column
    private String address;

    @Column
    private Integer number;

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
