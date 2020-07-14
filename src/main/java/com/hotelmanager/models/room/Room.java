package com.hotelmanager.models.room;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String view;
    private String number;

    @ManyToOne
    private FOStatus foStatus;

    @ManyToOne
    private HKStatus hkStatus;

    @ManyToOne
    private RoomRank roomRank;
}
