package com.hotelmanager.models.customer;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

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
    @ManyToMany(mappedBy = "bookings")
    private List<Customer> customers;
}
