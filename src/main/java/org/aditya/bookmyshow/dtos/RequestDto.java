package org.aditya.bookmyshow.dtos;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class RequestDto {
    Long userID;
    Long showID;
    List<Long> showseatID;

}
