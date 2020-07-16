package com.hotelmanager.formatters;

import com.hotelmanager.models.booking.Booking;
import com.hotelmanager.models.room.FOStatus;
import com.hotelmanager.services.intface.BookingService;
import com.hotelmanager.services.intface.FOStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.util.Locale;

@Component
public class BookingFormatter implements Formatter<Booking> {
    @Autowired
    private BookingService bookingService;
    @Override
    public Booking parse(String text, Locale locale) throws ParseException {
        return bookingService.findOne(Long.parseLong(text));
    }

    @Override
    public String print( Booking object, Locale locale) {
        return "[" + object.getId() + ", " +object.getAmount() + ", " +object.getDate_arrived() + ","
                 +object.getDate_booked() + ", "
                 +object.getDate_departed() + ", "
                 +object.getView() + ", "
                 +object.getRoomtypes() + ", "
                 +object.getPrice() + "]";
    }
}
