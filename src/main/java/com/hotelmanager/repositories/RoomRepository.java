package com.hotelmanager.repositories;

import com.hotelmanager.models.room.Room;
import org.springframework.data.repository.CrudRepository;

public interface RoomRepository extends CrudRepository<Room, Long> {
}
