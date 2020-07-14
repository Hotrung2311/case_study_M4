package com.hotelmanager.controllers;

import com.hotelmanager.models.room.FOStatus;
import com.hotelmanager.models.room.RoomRank;
import com.hotelmanager.services.intface.FOStatusService;
import com.hotelmanager.services.intface.RoomRankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/rooms/FO")
public class FOStatusController {
    @Autowired
    private FOStatusService foStatusService;

    @GetMapping("/list")
    public ModelAndView showAllRoomRank(){
        ModelAndView mv = new ModelAndView("room/FOStatus/list");
        mv.addObject("foStatuses", foStatusService.findAll());
        return mv;
    }

    @GetMapping("/create")
    public ModelAndView showDetailForm(){
        ModelAndView mv = new ModelAndView("room/FOStatus/save");
        mv.addObject("foStatus", new FOStatus());
        mv.addObject("action","Create new FO Status");
        return mv;
    }

    @GetMapping("/edit/{id}")
    public ModelAndView showEditForm(@PathVariable Long id){
        ModelAndView mv = new ModelAndView("room/FOStatus/save");
        mv.addObject("foStatus",foStatusService.findOne(id));
        mv.addObject("action","Edit Rank of Room " + foStatusService.findOne(id).getStatus());
        return mv;
    }
    @PostMapping("/save")
    public ModelAndView save(@ModelAttribute("foStatus") FOStatus foStatus){
        foStatusService.save(foStatus);
        ModelAndView mv = new ModelAndView("/room/FOStatus/save");
        mv.addObject("foStatus",foStatus);
        mv.addObject("action","Edit FO Status");
        mv.addObject("message","Saved !!!");
        return mv;
    }
    @GetMapping("/delete/{id}")
    public ModelAndView delete(@PathVariable("id") Long id){
        foStatusService.delete(id);
        ModelAndView mv = new ModelAndView( "room/FOStatus/list");
        mv.addObject("foStatuses",foStatusService.findAll());
        mv.addObject("message","Removed !!!");
        return mv;
    }
}
