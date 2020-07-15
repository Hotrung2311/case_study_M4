package com.hotelmanager.controllers;

import com.hotelmanager.models.room.RoomRank;
import com.hotelmanager.services.intface.RoomRankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/manager/rooms/ranks")
public class RoomRankController {
    @Autowired
    private RoomRankService roomRankService;

    @GetMapping("/list")
    public ModelAndView showAllRoomRank(){
        ModelAndView mv = new ModelAndView("room/rank/list");
        mv.addObject("roomRanks", roomRankService.findAll());
        return mv;
    }

    @GetMapping("/create")
    public ModelAndView showDetailForm(){
        ModelAndView mv = new ModelAndView("room/rank/save");
        mv.addObject("roomRank", new RoomRank());
        mv.addObject("action","Create new Rank of Room");
        return mv;
    }

    @GetMapping("/edit/{id}")
    public ModelAndView showEditForm(@PathVariable Long id){
        ModelAndView mv = new ModelAndView("room/rank/save");
        mv.addObject("roomRank",roomRankService.findOne(id));
        mv.addObject("action","Edit Rank of Room " + roomRankService.findOne(id).getStatus());
        return mv;
    }
    @PostMapping("/save")
    public ModelAndView save(@ModelAttribute("roomRank") RoomRank roomRank){
        roomRankService.save(roomRank);
        ModelAndView mv = new ModelAndView("/room/rank/save");
        mv.addObject("roomRank",roomRank);
        mv.addObject("action","Edit Rank of Room");
        mv.addObject("message","Saved !!!");
        return mv;
    }
    @GetMapping("/delete/{id}")
    public ModelAndView delete(@PathVariable("id") Long id){
        roomRankService.delete(id);
        ModelAndView mv = new ModelAndView( "room/rank/list");
        mv.addObject("roomRanks",roomRankService.findAll());
        mv.addObject("message","Removed !!!");
        return mv;
    }
}
