package com.hotelmanager.services.intface;

import com.hotelmanager.models.room.Room;
import com.hotelmanager.services.IService;

public interface RoomService extends IService<Room> {
    Room findByNumber(String number);
}
