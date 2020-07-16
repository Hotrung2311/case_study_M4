package com.hotelmanager.repositories;

import com.hotelmanager.models.booking.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


public interface BookingRepository extends CrudRepository<Booking, Long>  {
}
