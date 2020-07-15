package com.hotelmanager.models.booking;

import com.hotelmanager.models.room.RoomRank;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String date_booked;
    private String date_arrived;
    private String date_departed;
    private String roomtypes;
    private String view;
    private Integer amount;
    private Long price;

}
