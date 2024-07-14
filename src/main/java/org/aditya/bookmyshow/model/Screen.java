package org.aditya.bookmyshow.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Screen extends BaseModel{
    private String title;

    @OneToMany
    List<Seat> seats;
    @ElementCollection
    @Enumerated(EnumType.ORDINAL)
    List<FEATURE>   features;
}
