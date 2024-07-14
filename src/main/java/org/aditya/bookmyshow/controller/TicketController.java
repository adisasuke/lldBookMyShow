package org.aditya.bookmyshow.controller;

import org.aditya.bookmyshow.dtos.BOOKINGSTATUS;
import org.aditya.bookmyshow.dtos.RequestDto;
import org.aditya.bookmyshow.dtos.ResponseDto;
import org.aditya.bookmyshow.model.Booking;
import org.aditya.bookmyshow.service.TicketService;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class TicketController {

    private TicketService ticketService;

    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    public ResponseDto issueTicket(RequestDto requestDto) {

        Long userID = requestDto.getUserID();
        Long showID = requestDto.getShowID();
        List<Long> seatID = requestDto.getSeatID();

        Booking booking = ticketService.issueTicket(userID, showID, seatID);
        ResponseDto responseDto = new ResponseDto();
        if(booking == null)
        {
            responseDto.setBookingStatus(BOOKINGSTATUS.FAILURE);
            return responseDto;
        }
        responseDto.setBookingStatus(BOOKINGSTATUS.SUCCESS);
        responseDto.setBooking(booking);
        return responseDto;
    }
}

