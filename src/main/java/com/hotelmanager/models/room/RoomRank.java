package com.hotelmanager.models.room;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class RoomRank {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String status;
}
