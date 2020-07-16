package com.hotelmanager.services.Impl;

import com.hotelmanager.models.room.Room;
import com.hotelmanager.repositories.RoomRepository;
import com.hotelmanager.services.intface.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class RoomServiceImpl implements RoomService {
    @Autowired
    private RoomRepository roomRepository;
    @Override
    public List<Room> findAll() {
        return (List<Room>)roomRepository.findAll();
    }

    @Override
    public Room findOne(Long id) {
        return roomRepository.findById(id).orElse(null);
    }

    @Override
    public Room save(Room model) {
        return roomRepository.save(model);
    }

    @Override
    public Room delete(Long id) {
        Room room = this.findOne(id);
        roomRepository.delete(room);
        return room;
    }

    @Override
    public Room findByNumber(String number) {
        return roomRepository.findByNumber(number);
    }
}
