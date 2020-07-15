package com.hotelmanager.controllers;

import com.hotelmanager.models.room.FOStatus;
import com.hotelmanager.models.room.HKStatus;
import com.hotelmanager.models.room.Room;
import com.hotelmanager.models.room.RoomRank;
import com.hotelmanager.services.intface.FOStatusService;
import com.hotelmanager.services.intface.HKStatusService;
import com.hotelmanager.services.intface.RoomRankService;
import com.hotelmanager.services.intface.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/rooms")
public class RoomController {
    @Autowired
    private RoomService roomService;
    @Autowired
    private RoomRankService roomRankService;
    @Autowired
    private FOStatusService foStatusService;
    @Autowired
    private HKStatusService hkStatusService;

    @ModelAttribute("ranks")
    public List<RoomRank> getRank(){
        return  roomRankService.findAll();
    }
    @ModelAttribute("fos")
    public List<FOStatus> getFoStatus(){
        return  foStatusService.findAll();
    }
    @ModelAttribute("hks")
    public List<HKStatus> getHkStatus(){
        return  hkStatusService.findAll();
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
        mv.addObject("message", "Thêm thành công !");
        return mv;
    }
    @GetMapping("/delete/{id}")
    public  ModelAndView delete(@PathVariable("id") Long id){
        roomService.delete(id);
        ModelAndView mv = new ModelAndView("room/list");
        mv.addObject("rooms",roomService.findAll());
        mv.addObject("message","Removed !!!");
        return mv;
    }
}
