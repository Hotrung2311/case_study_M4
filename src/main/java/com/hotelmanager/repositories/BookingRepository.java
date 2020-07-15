package com.hotelmanager.repositories;

import com.hotelmanager.models.booking.Booking;
import org.springframework.data.repository.CrudRepository;

public interface BookingRepository extends CrudRepository<Booking, Long> {
}
