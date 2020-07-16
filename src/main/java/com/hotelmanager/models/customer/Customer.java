package com.hotelmanager.models.customer;

import com.hotelmanager.models.booking.Booking;
import com.hotelmanager.models.room.Room;
import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Data
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String firstName;
    private String lastName;

    @Column(unique = true)
    private String IDNumber;

    @Column(unique = true)
    private String phoneNumber;

    @Column(unique = true)
    private String email;

    private String company;
    private String address;
    @ManyToMany(mappedBy = "customers")
    @ToString.Exclude
    private Set<Booking> bookings;

    @ManyToMany(mappedBy = "customers")
    @ToString.Exclude
    private Set<Room> rooms;
}
