package com.hotelmanager.controllers;

import com.hotelmanager.models.account.Account;
import com.hotelmanager.models.account.Role;
import com.hotelmanager.services.intface.AccountService;
import com.hotelmanager.services.intface.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/accounts")
public class AccountController {
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private AccountService accountService;
    @Autowired
    private RoleService roleService;

    @ModelAttribute("roles")
    public List<Role> roles(){
        return roleService.findAll();
    }
    @GetMapping("/list")
    public ModelAndView showList(){
        ModelAndView modelAndView = new ModelAndView("/account/list");
        modelAndView.addObject("accounts",accountService.findAll());
        return modelAndView;
    }
    @GetMapping("/create")
    public ModelAndView showCreateForm(){
        ModelAndView mv = new ModelAndView("/account/save");
        mv.addObject("account",new Account());
        mv.addObject("action","Create new Account");
        return  mv;
    }
    @GetMapping("/edit/{id}")
    public  ModelAndView showEditForm(@PathVariable("id") Long id){
        Account account = accountService.findOne(id);
        ModelAndView mv = new ModelAndView("/account/save");
        mv.addObject("account",account);
        mv.addObject("action","Edit account "+account.getUsername());
        return mv;
    }
    @PostMapping("/save")
    public ModelAndView save(@ModelAttribute("account") Account account){
        account.setPassword(passwordEncoder.encode(account.getPassword()));
        accountService.save(account);
        ModelAndView mv = new ModelAndView("/account/save");
        mv.addObject("account",account);
        mv.addObject("message","Saving is successful !!! ");
        return mv;
    }
    @GetMapping("/delete/{id}")
    public ModelAndView delete(@PathVariable("id") Long id){
        accountService.delete(id);
        ModelAndView mv = new ModelAndView("/account/list");
        mv.addObject("accounts",accountService.findAll());
        mv.addObject("message","Delete is successful !!!");
        return mv;
    }
}
