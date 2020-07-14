package com.hotelmanager.formatters;

import com.hotelmanager.models.room.HKStatus;
import com.hotelmanager.services.intface.HKStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.util.Locale;
@Component
public class HKStatusFormatter implements Formatter<HKStatus> {
    @Autowired
    private HKStatusService hkStatusService;
    @Override
    public HKStatus parse(String text, Locale locale) throws ParseException {
        return hkStatusService.findOne(Long.parseLong(text));
    }

    @Override
    public String print(HKStatus object, Locale locale) {
        return "[" + object.getId() + ", " +object.getStatus() + "]";
    }
}
