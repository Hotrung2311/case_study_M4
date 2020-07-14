package com.hotelmanager.formatters;

import com.hotelmanager.models.account.Role;
import com.hotelmanager.services.intface.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.util.Locale;

@Component
public class RoleFormatter implements Formatter<Role> {
    @Autowired
    private RoleService roleService;
    @Override
    public Role parse(String text, Locale locale) throws ParseException {
        return roleService.findOne(Long.parseLong(text));
    }

    @Override
    public String print(Role object, Locale locale) {
        return "[" + object.getId() + ", " +object.getName() + "]";
    }
}
