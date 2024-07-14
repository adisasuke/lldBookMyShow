package org.aditya.bookmyshow.service;

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
    private SeatRepository seatRepository;;
    private ShowSeatRepository showSeatRepository;

    public TicketService(UserRepository userRepository, ShowRepository showRepository, SeatRepository seatRepository, ShowSeatRepository showSeatRepository) {
        this.userRepository = userRepository;
        this.showRepository = showRepository;
        this.seatRepository = seatRepository;
        this.showSeatRepository = showSeatRepository;
    }


    public Booking issueTicket(Long userID, Long showID, List<Long> seatID){

        Optional<User> user = userRepository.findById(userID);
        if(user.isEmpty())
        {
            return null;
        }
        Optional<Show> show = showRepository.findById(showID);
        if(show.isEmpty())
        {
            return null;
        }
        Screen screen = show.get().getScreen();
        LocalDateTime startTime = show.get().getStDateTime();
        LocalDateTime endTime = show.get().getEdDateTime();

        List<Seat> seats = seatRepository.findAllBy(seatID);
        List<ShowSeat> showSeats = showSeatRepository.findAllByShowIdAndSeat(seats, show);

        for(ShowSeat showSeat : showSeats)
        {
            if(showSeat.getSHOWSTATUS().equals(SHOWSTATUS.OCCUPIED) || showSeat.equals(SHOWSTATUS.PENDING))
            {
                return null;
            }
            else {

            }
        }

        return null;

    }
}
