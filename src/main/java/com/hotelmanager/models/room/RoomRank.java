package com.hotelmanager.models.room;

import com.hotelmanager.models.booking.Booking;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Table(name = "roomrank1")
public class RoomRank {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String status;
}
