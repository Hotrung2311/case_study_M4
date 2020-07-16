package com.hotelmanager.models.customer;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class InternetBooking {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String firstName;
    private String lastName;

    private String idNumber;

    @Column(unique = true)
    private String phoneNumber;

    private String checkin;
    private String checkout;

    private int guestNumber;
}
