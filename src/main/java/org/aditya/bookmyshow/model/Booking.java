package org.aditya.bookmyshow.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@Entity
public class Booking extends BaseModel{

    @ManyToOne
    Show show;
    @ManyToOne
    Screen screen;


    Date bookedAt;

    @ManyToOne
    User user;

    @ManyToMany
    List<ShowSeat> showSeats;

    @Enumerated(EnumType.ORDINAL)
    BOOKINGSTATUS bookingStatus;

    @OneToMany
    List<Payment> payments;
    int totalAmount;

}
