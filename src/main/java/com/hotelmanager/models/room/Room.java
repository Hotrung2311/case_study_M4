package com.hotelmanager.models.room;

import com.hotelmanager.models.customer.Customer;
import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;



@Entity
@Data
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String view;
    @Column(unique = true)
    private String number;

    @ManyToOne
    private FOStatus foStatus;

    @ManyToOne
    private HKStatus hkStatus;

    @ManyToOne
    private RoomRank roomRank;
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @ToString.Exclude
    @JoinTable( name = "room_customer",
            joinColumns = @JoinColumn(name = "room_id"),
            inverseJoinColumns = @JoinColumn(name = "customer_id"))
    private List<Customer> customers;
}
