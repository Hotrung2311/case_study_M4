package com.hotelmanager.controllers;

import com.hotelmanager.models.customer.InternetBooking;
import com.hotelmanager.services.intface.InternetBookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/home")
public class HomePageController {

    @Autowired
    private InternetBookingService internetBookingService;

    @GetMapping("")
    public ModelAndView showHomepage(){
        ModelAndView mv = new ModelAndView("home/home");
        mv.addObject("internetBooking", new InternetBooking());
        return mv;
    }

    @PostMapping("/booking")
    public ModelAndView bookingRoom(@ModelAttribute InternetBooking internetBooking){
        ModelAndView mv = new ModelAndView("home/Thanks");
        internetBookingService.save(internetBooking);
        return mv;
    }
}
