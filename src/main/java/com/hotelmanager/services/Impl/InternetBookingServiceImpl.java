package com.hotelmanager.services.Impl;

import com.hotelmanager.models.customer.InternetBooking;
import com.hotelmanager.repositories.InternetBookingRepository;
import com.hotelmanager.services.intface.InternetBookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InternetBookingServiceImpl implements InternetBookingService {

    @Autowired
    private InternetBookingRepository internetBookingRepository;

    @Override
    public List<InternetBooking> findAll() {
        return (List<InternetBooking>) internetBookingRepository.findAll();
    }

    @Override
    public InternetBooking findOne(Long id) {
        return internetBookingRepository.findById(id).orElse(null);
    }

    @Override
    public InternetBooking save(InternetBooking model) {
        return internetBookingRepository.save(model);
    }

    @Override
    public InternetBooking delete(Long id) {
        InternetBooking internetBooking = this.findOne(id);
        internetBookingRepository.delete(internetBooking);
        return internetBooking;
    }
}
