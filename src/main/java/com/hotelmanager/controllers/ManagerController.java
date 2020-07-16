package com.hotelmanager.controllers;

import com.hotelmanager.models.booking.Booking;
import com.hotelmanager.models.customer.Customer;
import com.hotelmanager.models.customer.InternetBooking;
import com.hotelmanager.models.room.FOStatus;
import com.hotelmanager.models.room.HKStatus;
import com.hotelmanager.models.room.Room;
import com.hotelmanager.models.temp.Temp;
import com.hotelmanager.services.Impl.CustomerServiceImpl;
import com.hotelmanager.services.intface.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/manager")
public class ManagerController {
    @Autowired
    private RoomService roomService;
    @Autowired
    private FOStatusService foStatusService;
    @Autowired
    private HKStatusService hkStatusService;
    @Autowired
    private BookingService bookingService;
    @Autowired
    private InternetBookingService internetBookingService;
    @Autowired
    private CustomerService customerService;
    @ModelAttribute("temp")
    public Temp ge(){
        return new Temp();
    }
    @ModelAttribute("fos")
    public List<FOStatus> getFoStatus() {
        return foStatusService.findAll();
    }
    @ModelAttribute("hks")
    public List<HKStatus> getHkStatus(){
        return hkStatusService.findAll();
    }


    @GetMapping("")
    public ModelAndView home() {
        return new ModelAndView("/manager/home");
    }

    @GetMapping("/admin")
    public ModelAndView admin() {
        return new ModelAndView("/manager/admin");
    }

    @GetMapping("/fo")
    public ModelAndView foManager() {
        ModelAndView mv = new ModelAndView("/manager/fo");
        mv.addObject("rooms", roomService.findAll());
        return mv;
    }

    @GetMapping("/hk")
    public ModelAndView hkManager() {
        ModelAndView mv = new ModelAndView("/manager/hk");
        mv.addObject("rooms", roomService.findAll());
        return mv;
    }
    @GetMapping("/re")
    public ModelAndView reManager(){
        ModelAndView mv = new ModelAndView("/manager/re");
        mv.addObject("iBookings",internetBookingService.findAll());
        return mv;
    }
    @GetMapping("/re/add/{id}")
    public ModelAndView reAddToFoBooking(@PathVariable("id") Long id){
        InternetBooking internetBooking = internetBookingService.findOne(id);
        internetBookingService.delete(id);
        Customer customer = new Customer();
        Booking booking = new Booking();
        booking.setDate_arrived(internetBooking.getCheckin());
        booking.setDate_departed(internetBooking.getCheckout());
        booking.setAmount(internetBooking.getGuestNumber());
        booking.setPrice(internetBooking.getRate());
        customer.setFirstName(internetBooking.getFirstName());
        customer.setLastName(internetBooking.getLastName());
        customer.setPhoneNumber(internetBooking.getPhoneNumber());
        customer.setIDNumber(internetBooking.getIdNumber());
        customer.getBookings().add(booking);
        booking.getCustomers().add(customer);
        bookingService.save(booking);
        customerService.save(customer);
        ModelAndView modelAndView = new ModelAndView("/manager/re");
        modelAndView.addObject("bookings",bookingService.findAll());
        return modelAndView;
    }

    @GetMapping("/fo/assign")
    public ModelAndView foAssign(){
        ModelAndView mv = new ModelAndView("/manager/foAssign");
        mv.addObject("books",bookingService.findAll());
        mv.addObject("rooms",roomService.findAll());
        return mv;
    }
    @PostMapping("/assignment")
    public ModelAndView assignment(@ModelAttribute("temp") Temp temp){
        Room room = roomService.findByNumber(temp.getNumber());
        Booking booking = bookingService.findOne(temp.getId());
        room.getCustomers().addAll(booking.getCustomers());
        bookingService.delete(temp.getId());
        roomService.save(room);
        ModelAndView mv = new ModelAndView("/manager/foAssign");
        mv.addObject("books",bookingService.findAll());
        mv.addObject("rooms",roomService.findAll());
        return mv;
    }

    @GetMapping("/index")
    public ModelAndView indexManager(){
        ModelAndView mv = new ModelAndView("/manager/index");
//        mv.addObject("bookings",bookingService.findAll());
        return mv;
    }
}
