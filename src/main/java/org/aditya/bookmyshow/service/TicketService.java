package org.aditya.bookmyshow.service;

import jakarta.persistence.*;
import org.aditya.bookmyshow.Exception.ShowNotFoundException;
import org.aditya.bookmyshow.Exception.ShowSeatNotAvailableException;
import org.aditya.bookmyshow.Exception.UserNotFoundException;
import org.aditya.bookmyshow.model.*;
import org.aditya.bookmyshow.repository.SeatRepository;
import org.aditya.bookmyshow.repository.ShowRepository;
import org.aditya.bookmyshow.repository.ShowSeatRepository;
import org.aditya.bookmyshow.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Date;
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

    @Transactional(isolation = Isolation.SERIALIZABLE)
    public Booking issueTicket(Long userID, Long showID, List<Long> showSeatIDs) throws UserNotFoundException, ShowNotFoundException, ShowSeatNotAvailableException {

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

        //check if available or blocked for more than 15 min

        for(ShowSeat showSeat : showSeats)
        {
            if(!(showSeat.getShowSeatStatus()==ShowSeatStatus.AVAILABLE))
            {
                throw new ShowSeatNotAvailableException();
            }
        }

        Date currDate = new Date();

        for(ShowSeat showSeat : showSeats)
        {
            long timeInMinutes = (currDate.getTime() - showSeat.getBlockedAt().getTime())/60*1000;

            if(!(showSeat.getShowSeatStatus()==ShowSeatStatus.BLOCKED && timeInMinutes>=15))
            {
                throw new ShowSeatNotAvailableException();
            }
        }

        Screen screen = show.getScreen();

        int total_amout = 0;
        //calculate this amount using price calculator service
        Booking booking = new Booking();
        booking.setUser(userOptional.get());
        booking.setShowSeats(showSeats);
        booking.setShow(show);
        booking.setScreen(screen);
        booking.setBookedAt(currDate);
        booking.setBookingStatus(BOOKINGSTATUS.PENDING);
        booking.setTotalAmount(total_amout);
        //save booking in database before returning

        return booking;

    }
}


