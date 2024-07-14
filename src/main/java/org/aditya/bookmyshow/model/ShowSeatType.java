package org.aditya.bookmyshow.model;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class ShowSeatType extends  BaseModel{

    @ManyToOne
    Show show;
    @ManyToOne
    Seat seat;
    Long price;
}
