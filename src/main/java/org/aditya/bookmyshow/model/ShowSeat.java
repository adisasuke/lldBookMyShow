package org.aditya.bookmyshow.model;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Setter
@Getter
public class ShowSeat extends BaseModel{
        @ManyToOne
        Show show;
        @ManyToOne
        Seat seat;

        @Enumerated(EnumType.ORDINAL)
        ShowSeatStatus showSeatStatus   ;


        private Date blockedAt;


}
