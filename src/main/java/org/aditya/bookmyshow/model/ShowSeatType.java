package org.aditya.bookmyshow.model;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class ShowSeatType extends  BaseModel{

    @ManyToOne
    Show show;

    @Enumerated(EnumType.ORDINAL)
    SEATTYPE seatType;
    Long price;
}
