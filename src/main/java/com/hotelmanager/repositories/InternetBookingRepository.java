package com.hotelmanager.repositories;

import com.hotelmanager.models.customer.InternetBooking;
import org.springframework.data.repository.CrudRepository;

public interface InternetBookingRepository extends CrudRepository<InternetBooking, Long> {
}
