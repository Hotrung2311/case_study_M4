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
    public ModelAndView showListCustomer() {
        List<Booking> bookings = bookingService.findAll();
        ModelAndView mv = new ModelAndView("/booking/list");
        mv.addObject("customers", bookings);
        return mv;
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
        System.out.println(booking.getRoomtypes());
        bookingService.save(booking);
//        ModelAndView mv = new ModelAndView("/booking/save");
//        model.addAttribute("booking", booking);
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

//    @Autowired
//    private BookingService bookingService;
//
//    @ModelAttribute("booking")
//    public List<Booking> getBooking(){
//        return bookingService.findAll();
//    }
//
//    @GetMapping("/list")
//    public ModelAndView showAllRoom(){
//        ModelAndView mv = new ModelAndView("/booking/list");
//        mv.addObject("bookings", bookingService.findAll());
//        return mv;
//    }
//
//    @GetMapping("/create")
//    public ModelAndView createNewRoom(){
//        ModelAndView mv = new ModelAndView("/booking/save");
//        mv.addObject("action","Create new Booking");
//        mv.addObject("booking", new Booking());
//        return mv;
//    }
//
//    @GetMapping("/edit/{id}")
//    public ModelAndView createNewRoom(@PathVariable Long id){
//        ModelAndView mv = new ModelAndView("/booking/save");
//        mv.addObject("action","Edit booking detail");
//        mv.addObject("booking", bookingService.findOne(id));
//        return mv;
//    }
//

}
