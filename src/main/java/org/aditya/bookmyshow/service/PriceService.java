package org.aditya.bookmyshow.service;

import org.aditya.bookmyshow.model.Show;
import org.aditya.bookmyshow.model.ShowSeat;
import org.aditya.bookmyshow.model.ShowSeatType;
import org.aditya.bookmyshow.repository.ShowSeatTypeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PriceService {

    private ShowSeatTypeRepository showSeatTypeRepository;

    public PriceService(ShowSeatTypeRepository showSeatTypeRepository) {
        this.showSeatTypeRepository = showSeatTypeRepository;
    }

    public Long calculatePrice(List<ShowSeat> showSeats, Show show)
    {
        Long amount = 0L;

        List<ShowSeatType> showSeatTypes = showSeatTypeRepository.findAllByShow(show);

        for (ShowSeatType showSeatType : showSeatTypes)
        {
            for(ShowSeat showSeat : showSeats)
            {
                if(showSeat.getSeat().getSeattype().equals(showSeatType.getSeatType()))
                {
                    amount += showSeatType.getPrice();
                }
            }
        }

        return amount;
    }
}
