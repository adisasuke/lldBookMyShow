package org.aditya.bookmyshow.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.aditya.bookmyshow.model.Seat;

import java.util.List;

public interface SeatRepository extends JpaRepository<Seat, Long> {

    List<Seat> findAllByIdIn(List<Long> seatID);

}
