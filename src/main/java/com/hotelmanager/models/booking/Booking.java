package com.hotelmanager.models.booking;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
@Data
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Date date_booked;
    private Date date_arrived;
    private Date date_departed;

    private String roomRank;
    private String view;
    private Integer amount;
    private Long price;

}
