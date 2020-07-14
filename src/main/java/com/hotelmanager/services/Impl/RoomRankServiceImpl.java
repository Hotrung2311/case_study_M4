package com.hotelmanager.services.Impl;

import com.hotelmanager.models.room.RoomRank;
import com.hotelmanager.repositories.RoomRankRepository;
import com.hotelmanager.repositories.RoomRepository;
import com.hotelmanager.services.intface.RoomRankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class RoomRankServiceImpl implements RoomRankService {
    @Autowired
    private RoomRankRepository roomRankRepository;

    @Override
    public List<RoomRank> findAll() {
        return (List<RoomRank>)roomRankRepository.findAll();
    }

    @Override
    public RoomRank findOne(Long id) {
        return roomRankRepository.findById(id).orElse(null);
    }

    @Override
    public RoomRank save(RoomRank model) {
        return roomRankRepository.save(model);
    }

    @Override
    public RoomRank delete(Long id) {
        RoomRank roomRank = this.findOne(id);
        roomRankRepository.delete(roomRank);
        return roomRank;
    }
}
