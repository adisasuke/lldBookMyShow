package org.aditya.bookmyshow.model;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class Movie extends BaseModel{
    private String title;
    @ElementCollection
    @Enumerated(EnumType.ORDINAL)
    List<FEATURE> featureList;
}
