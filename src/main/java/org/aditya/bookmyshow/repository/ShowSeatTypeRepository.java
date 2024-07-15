package org.aditya.bookmyshow.repository;

import org.aditya.bookmyshow.model.Show;
import org.aditya.bookmyshow.model.ShowSeatType;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ShowSeatTypeRepository extends JpaRepository<ShowSeatType, Long> {

    List<ShowSeatType> findAllByShow(Show show);
}
