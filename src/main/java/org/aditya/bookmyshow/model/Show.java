package org.aditya.bookmyshow.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "`show`")
public class Show extends BaseModel{
    @ManyToOne
    private Movie movie;
    @ManyToOne
    Screen screen;
    LocalDateTime stDateTime;
    LocalDateTime edDateTime;
    @ElementCollection
    @Enumerated(EnumType.ORDINAL)
    List<FEATURE> features;

}
