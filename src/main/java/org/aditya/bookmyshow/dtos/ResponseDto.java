package org.aditya.bookmyshow.dtos;

import lombok.Getter;
import lombok.Setter;
import org.aditya.bookmyshow.model.BOOKINGSTATUS;
import org.aditya.bookmyshow.model.Booking;

@Getter
@Setter
public class ResponseDto {
    Booking booking;
    BOOKINGSTATUS bookingStatus;
}
