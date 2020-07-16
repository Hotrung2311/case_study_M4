package com.hotelmanager.models.booking;

import com.hotelmanager.models.room.RoomRank;
import lombok.Data;


import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String date_booked;
    private String date_arrived;
    private String date_departed;
    @ManyToOne
    private RoomRank roomRank;
    private String view;
    private Integer amount;
    private Long price;
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(name = "booking_customer",
    joinColumns = @JoinColumn("booking_id") ,
    inverseJoinColumns = @JoinColumn("customer_id"))
    private List<Booking> bookings;

}
