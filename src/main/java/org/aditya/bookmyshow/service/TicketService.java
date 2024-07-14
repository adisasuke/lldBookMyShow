package org.aditya.bookmyshow.service;

import org.aditya.bookmyshow.Exception.ShowNotFoundException;
import org.aditya.bookmyshow.Exception.UserNotFoundException;
import org.aditya.bookmyshow.model.*;
import org.aditya.bookmyshow.repository.SeatRepository;
import org.aditya.bookmyshow.repository.ShowRepository;
import org.aditya.bookmyshow.repository.ShowSeatRepository;
import org.aditya.bookmyshow.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class TicketService {


    private UserRepository userRepository;
    private ShowRepository showRepository;
    private ShowSeatRepository showSeatRepository;

    public TicketService(UserRepository userRepository, ShowRepository showRepository, ShowSeatRepository showSeatRepository) {
        this.userRepository = userRepository;
        this.showRepository = showRepository;
        this.showSeatRepository = showSeatRepository;
    }


    public Booking issueTicket(Long userID, Long showID, List<Long> showSeatIDs) throws UserNotFoundException, ShowNotFoundException {

        Optional<User> userOptional = userRepository.findById(userID);
        if(userOptional.isEmpty())
        {
            throw new UserNotFoundException();
        }


        Optional<Show> showOptional = showRepository.findById(showID);
        if(showOptional.isEmpty())
        {
            throw new ShowNotFoundException();
        }
        Show show = showOptional.get();



        List<ShowSeat> showSeats = showSeatRepository.findAllById(showSeatIDs);

//        for(ShowSeat showSeat : showSeats)
//        {
//            if(showSeat.getSHOWSTATUS().equals(SHOWSTATUS.OCCUPIED) || showSeat.equals(SHOWSTATUS.PENDING))
//            {
//                return null;
//            }
//            else {
//
//            }
//        }



//        List<Seat> seats = seatRepository.findAllBy(seatID);
//        Screen screen = show.get().getScreen();
//        LocalDateTime startTime = show.get().getStDateTime();
//        LocalDateTime endTime = show.get().getEdDateTime();
        return null;

    }
}
