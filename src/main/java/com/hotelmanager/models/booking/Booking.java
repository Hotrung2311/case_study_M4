package com.hotelmanager.models.booking;

import com.hotelmanager.models.customer.Customer;
import com.hotelmanager.models.room.RoomRank;
import lombok.Data;
import lombok.ToString;


import javax.persistence.*;
import java.util.Set;


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
    @ToString.Exclude
    @JoinTable( name = "booking_customer",
            joinColumns = @JoinColumn(name = "booking_id"),
            inverseJoinColumns = @JoinColumn(name = "customer_id"))
    private Set<Customer> customers;

}
