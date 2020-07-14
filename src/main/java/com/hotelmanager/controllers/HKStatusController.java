package com.hotelmanager.controllers;

import com.hotelmanager.models.room.FOStatus;
import com.hotelmanager.models.room.HKStatus;
import com.hotelmanager.services.intface.FOStatusService;
import com.hotelmanager.services.intface.HKStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/rooms/HK")
public class HKStatusController {
    @Autowired
    private HKStatusService hkStatusService;

    @GetMapping("/list")
    public ModelAndView showAllRoomRank(){
        ModelAndView mv = new ModelAndView("room/HKStatus/list");
        mv.addObject("hkStatuses", hkStatusService.findAll());
        return mv;
    }

    @GetMapping("/create")
    public ModelAndView showDetailForm(){
        ModelAndView mv = new ModelAndView("room/HKStatus/save");
        mv.addObject("hkStatus", new FOStatus());
        mv.addObject("action","Create new HK Status");
        return mv;
    }

    @GetMapping("/edit/{id}")
    public ModelAndView showEditForm(@PathVariable Long id){
        ModelAndView mv = new ModelAndView("room/HKStatus/save");
        mv.addObject("hkStatus",hkStatusService.findOne(id));
        mv.addObject("action","Edit HK Status " + hkStatusService.findOne(id).getStatus());
        return mv;
    }
    @PostMapping("/save")
    public ModelAndView save(@ModelAttribute("hkStatus") HKStatus hkStatus){
        hkStatusService.save(hkStatus);
        ModelAndView mv = new ModelAndView("/room/HKStatus/save");
        mv.addObject("hkStatus",hkStatus);
        mv.addObject("action","Edit HK Status");
        mv.addObject("message","Saved !!!");
        return mv;
    }
    @GetMapping("/delete/{id}")
    public ModelAndView delete(@PathVariable("id") Long id){
        hkStatusService.delete(id);
        ModelAndView mv = new ModelAndView( "room/HKStatus/list");
        mv.addObject("hkStatuses",hkStatusService.findAll());
        mv.addObject("message","Removed !!!");
        return mv;
    }
}
