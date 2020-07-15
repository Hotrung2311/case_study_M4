package com.hotelmanager.controllers;

import com.hotelmanager.models.room.FOStatus;
import com.hotelmanager.services.intface.FOStatusService;
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

    @ModelAttribute("fos")
    public List<FOStatus> getFoStatus() {
        return foStatusService.findAll();
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
        return new ModelAndView("/manager/hk");
    }
}
