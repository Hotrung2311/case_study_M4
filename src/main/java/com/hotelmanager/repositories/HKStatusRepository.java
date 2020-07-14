package com.hotelmanager.repositories;

import com.hotelmanager.models.room.HKStatus;
import org.springframework.data.repository.CrudRepository;

public interface HKStatusRepository extends CrudRepository<HKStatus, Long> {
}
