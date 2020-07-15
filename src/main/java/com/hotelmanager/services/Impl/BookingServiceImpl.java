package com.hotelmanager.services.Impl;

import com.hotelmanager.models.booking.Booking;
import com.hotelmanager.repositories.BookingRepository;
import com.hotelmanager.services.intface.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingServiceImpl implements BookingService {
    @Autowired
    private BookingRepository bookingRepository;

    @Override
    public List<Booking> findAll() {
        return (List<Booking>) bookingRepository.findAll();
    }

    @Override
    public Booking findOne(Long id) {
        return bookingRepository.findById(id).get();
    }

    @Override
    public Booking save(Booking booking) {
        return bookingRepository.save(booking);
    }

    @Override
    public Booking delete(Long id) {
        Booking booking = findOne(id);
        bookingRepository.delete(booking);
//        Booking booking = bookingRepository.findById(id).get();
        return booking;
    }
}
