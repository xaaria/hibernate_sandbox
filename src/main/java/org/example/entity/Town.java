package org.example.entity;

import jakarta.persistence.Embeddable;

// Testing how Embeddable works

@Embeddable
public class Town {
    private String  name;
    private Integer population;
}
