package com.hotelmanager.controllers;

import com.hotelmanager.models.account.Role;
import com.hotelmanager.services.intface.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/manager/roles")
public class RoleController {
    @Autowired
    private RoleService roleService;
    @GetMapping("/list")
    public ModelAndView showList(){
        ModelAndView modelAndView = new ModelAndView("/account/role/list");
        modelAndView.addObject("roles", roleService.findAll());
        return modelAndView;
    }
    @GetMapping("/create")
    public ModelAndView showCreateForm(){
        ModelAndView mv = new ModelAndView("/account/role/save");
        mv.addObject("role",new Role());
        mv.addObject("action","Create new Role");
        return  mv;
    }
    @GetMapping("/edit/{id}")
    public  ModelAndView showEditForm(@PathVariable("id") Long id){
        Role role = roleService.findOne(id);
        ModelAndView mv = new ModelAndView("/account/role/save");
        mv.addObject("role",role);
        mv.addObject("action","Edit role "+role.getName());
        return mv;
    }
    @PostMapping("/save")
    public ModelAndView save(@ModelAttribute("role") Role role){
        roleService.save(role);
        ModelAndView mv = new ModelAndView("/account/role/save");
        mv.addObject("role",role);
        mv.addObject("message","Saving is successful !!! ");
        return mv;
    }
    @GetMapping("/delete/{id}")
    public ModelAndView delete(@PathVariable("id") Long id){
        roleService.delete(id);
        ModelAndView mv = new ModelAndView("/account/role/list");
        mv.addObject("roles",roleService.findAll());
        mv.addObject("message","Delete is successful !!!");
        return mv;
    }
}
