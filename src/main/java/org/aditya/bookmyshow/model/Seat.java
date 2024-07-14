package org.aditya.bookmyshow.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Seat extends BaseModel{
    private String seatNumber;
    int row;
    int col;

    @Enumerated(EnumType.ORDINAL)
    SEATTYPE seattype;
    @ManyToOne
    Screen screen;

}
