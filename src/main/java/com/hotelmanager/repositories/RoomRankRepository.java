package com.hotelmanager.repositories;

import com.hotelmanager.models.room.RoomRank;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


public interface RoomRankRepository extends CrudRepository<RoomRank, Long>  {
}
