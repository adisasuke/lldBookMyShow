package org.aditya.bookmyshow.repository;

import org.aditya.bookmyshow.model.Seat;
import org.aditya.bookmyshow.model.Show;
import org.aditya.bookmyshow.model.ShowSeat;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ShowSeatRepository extends JpaRepository<ShowSeat, Long> {

//    List<ShowSeat> findAllByShowIdAndSeat(List<Seat> seats, Optional<Show> show);
    List<ShowSeat> findAllById(List<Long> showIds);
}
