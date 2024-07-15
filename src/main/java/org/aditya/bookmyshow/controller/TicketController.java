package org.aditya.bookmyshow.controller;

import org.aditya.bookmyshow.dtos.RequestDto;
import org.aditya.bookmyshow.dtos.ResponseDto;
import org.aditya.bookmyshow.model.Booking;
import org.aditya.bookmyshow.service.TicketService;
import org.springframework.stereotype.Controller;
import org.aditya.bookmyshow.model.BOOKINGSTATUS;

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
        List<Long> showSeatIDs = requestDto.getShowseatID();

        Booking booking = null;
        ResponseDto responseDto = new ResponseDto();
        try {
            booking = ticketService.issueTicket(userID, showID, showSeatIDs);
        }
        catch (Exception e) {
            e.printStackTrace();
            responseDto.setBookingStatus(BOOKINGSTATUS.FAILED);
        }

        responseDto.setBookingStatus(BOOKINGSTATUS.PENDING);
        responseDto.setBooking(booking);
        return responseDto;
    }
}

