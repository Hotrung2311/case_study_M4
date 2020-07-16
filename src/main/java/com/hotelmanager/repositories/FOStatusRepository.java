package com.hotelmanager.repositories;

import com.hotelmanager.models.room.FOStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


public interface FOStatusRepository extends CrudRepository<FOStatus, Long>{
}
