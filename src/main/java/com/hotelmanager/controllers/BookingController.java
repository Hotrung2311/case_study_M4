package com.hotelmanager.controllers;

import com.hotelmanager.models.booking.Booking;
import com.hotelmanager.models.customer.Customer;
import com.hotelmanager.models.room.FOStatus;
import com.hotelmanager.models.room.HKStatus;
import com.hotelmanager.models.room.Room;
import com.hotelmanager.models.room.RoomRank;
import com.hotelmanager.services.intface.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/booking")
public class BookingController {

    @Autowired
    private BookingService bookingService;

    @GetMapping("/list")
    public ModelAndView showBookingList() {
        List<Booking> bookings = bookingService.findAll();
        ModelAndView mv = new ModelAndView("/booking/list");
        mv.addObject("bookings", bookings);
        return mv;
    }

    @GetMapping("/create")
    public ModelAndView showCreateBookingForm(){
        ModelAndView mv = new ModelAndView("/booking/save");
        mv.addObject("action","Create new booking");
        mv.addObject("booking", new Booking());
        return mv;
    }

    @PostMapping("/save")
    public String saveBooking(@ModelAttribute("booking") Booking booking, Model model){
        System.out.println(booking.getRoomtypes());
        bookingService.save(booking);
        model.addAttribute("message","Saving is successful");
        return "redirect:/booking/create";
    }

    @GetMapping("/edit/{id}")
    public ModelAndView showEditForm(@PathVariable("id") Long id){
        Booking booking = bookingService.findOne(id);
        ModelAndView mv = new ModelAndView("/booking/save");
        mv.addObject("booking",booking);
        return mv;
    }
    @GetMapping("/delete/{id}")
    public ModelAndView delete(@PathVariable("id") Long id){
        bookingService.delete(id);
        ModelAndView mv = new ModelAndView("/booking/list");
        mv.addObject("bookings",bookingService.findAll());
        mv.addObject("message","Removed !!!");
        return mv;
    }

}
