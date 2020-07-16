package com.hotelmanager.controllers;

import com.hotelmanager.models.booking.Booking;
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
    @Autowired
    private RoomRankService roomRankService;

    @ModelAttribute("ranks")
    public List<RoomRank> roomRank(){
        return  roomRankService.findAll();
    }
    @GetMapping("/create")
    public ModelAndView showCreateCustomerForm(){
        ModelAndView mv = new ModelAndView("/booking/save");
        mv.addObject("action","Create new booking");
        mv.addObject("booking", new Booking());
        return mv;
    }

    @PostMapping("/save")
    public String saveCustomer(@ModelAttribute("booking") Booking booking, Model model){
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
        ModelAndView mv = new ModelAndView("/manager/re");
        mv.addObject("bookings",bookingService.findAll());
        mv.addObject("message","Removed !!!");
        return mv;
    }
}
