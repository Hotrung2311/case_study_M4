package com.hotelmanager.formatters;

import com.hotelmanager.models.room.RoomRank;
import com.hotelmanager.services.intface.RoomRankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.util.Locale;
@Component
public class RoomRankFormatter implements Formatter<RoomRank> {
    @Autowired
    private RoomRankService roomRankService;
    @Override
    public RoomRank parse(String text, Locale locale) throws ParseException {
        return roomRankService.findOne(Long.parseLong(text));
    }

    @Override
    public String print(RoomRank object, Locale locale) {
        return "[" + object.getId() + ", " +object.getStatus() + "]";
    }
}
