package org.aditya.bookmyshow.model;

import jakarta.persistence.Entity;

import java.util.List;

@Entity
public class Region extends BaseModel{
    private String regionName;
    private List<Theatre> theatres;

}
