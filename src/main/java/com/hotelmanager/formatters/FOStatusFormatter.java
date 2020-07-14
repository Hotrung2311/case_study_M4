package com.hotelmanager.formatters;

import com.hotelmanager.models.account.Role;
import com.hotelmanager.models.room.FOStatus;
import com.hotelmanager.services.intface.FOStatusService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.util.Locale;
@Component
public class FOStatusFormatter implements Formatter<FOStatus> {
    @Autowired
    private FOStatusService foStatusService;
    @Override
    public FOStatus parse(String text, Locale locale) throws ParseException {
        return foStatusService.findOne(Long.parseLong(text));
    }

    @Override
    public String print(FOStatus object, Locale locale) {
        return "[" + object.getId() + ", " +object.getStatus() + "]";
    }
}
