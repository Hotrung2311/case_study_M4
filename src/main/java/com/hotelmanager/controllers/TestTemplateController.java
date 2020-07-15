package com.hotelmanager.controllers;

import com.hotelmanager.models.room.Room;
import com.hotelmanager.services.intface.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/template")
public class TestTemplateController {

    @Autowired
    private RoomService roomService;

    @GetMapping("/booking")
    public String bookingView() {
        return "/templates_ok/booking";
    }

    @GetMapping("/login")
    public String LoginView() {
        return "/templates_ok/login";
    }

    @GetMapping("/tables")
    public ModelAndView ListView() {
        ModelAndView mv = new ModelAndView("/templates_ok/tables");
        mv.addObject("rooms", roomService.findAll());
        return mv;
    }

    @GetMapping("/list")
    public ModelAndView showAllRoom(){
        ModelAndView mv = new ModelAndView("/room/list");
        mv.addObject("rooms", roomService.findAll());
        return mv;
    }

    @GetMapping("/create")
    public ModelAndView createNewRoom(){
        ModelAndView mv = new ModelAndView("/room/save");
        mv.addObject("action","Create new Room");
        mv.addObject("room", new Room());
        return mv;
    }

    @GetMapping("/edit/{id}")
    public ModelAndView createNewRoom(@PathVariable Long id){
        ModelAndView mv = new ModelAndView("/room/save");
        mv.addObject("action","Edit room detail");
        mv.addObject("room", roomService.findOne(id));
        return mv;
    }

    @PostMapping("/save")
    public ModelAndView saveRoom(@ModelAttribute("room")Room room){
        roomService.save(room);
        ModelAndView mv = new ModelAndView("/room/save");
        mv.addObject("room",room);
        mv.addObject("message", "Thêm thành công!");
        return mv;
    }
}
