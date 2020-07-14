package com.hotelmanager.controllers;

import com.hotelmanager.models.room.Room;
import com.hotelmanager.services.intface.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/rooms")
public class RoomController {
    @Autowired
    private RoomService roomService;

    @GetMapping("")
    public ModelAndView showAllRoom(){
        ModelAndView mv = new ModelAndView("list");
        mv.addObject("roomlist", roomService.findAll());
        return mv;
    }

    @GetMapping("/create-new")
    public ModelAndView createNewRoom(){
        ModelAndView mv = new ModelAndView("save");
        mv.addObject("room", new Room());
        return mv;
    }

    @GetMapping("/edit/{id}")
    public ModelAndView createNewRoom(@PathVariable Long id){
        ModelAndView mv = new ModelAndView("save");
        mv.addObject("room", roomService.findOne(id));
        return mv;
    }

    @PostMapping("/rooms/save-room")
    public ModelAndView saveRoom(@ModelAttribute("room") Room room){
        roomService.save(room);
        ModelAndView mv = new ModelAndView("save");
        mv.addObject("message", "Thêm thành công !");
        return mv;
    }
}
