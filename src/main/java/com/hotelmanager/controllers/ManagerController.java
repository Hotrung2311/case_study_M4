package com.hotelmanager.controllers;

import com.hotelmanager.models.room.FOStatus;
import com.hotelmanager.models.room.HKStatus;
import com.hotelmanager.services.intface.BookingService;
import com.hotelmanager.services.intface.FOStatusService;
import com.hotelmanager.services.intface.HKStatusService;
import com.hotelmanager.services.intface.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
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
        mv.addObject("bookings",bookingService.findAll());
        return mv;
    }

    @GetMapping("/index")
    public ModelAndView indexManager(){
        ModelAndView mv = new ModelAndView("/manager/index");
//        mv.addObject("bookings",bookingService.findAll());
        return mv;
    }
}
