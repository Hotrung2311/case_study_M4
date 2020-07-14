package com.hotelmanager.controllers;

import com.hotelmanager.models.customer.Customer;
import com.hotelmanager.services.intface.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @GetMapping("/list")
    public ModelAndView showListCustomer() {
        List<Customer> customers = customerService.findAll();
        ModelAndView mv = new ModelAndView("/customer/list");
        mv.addObject("customers", customers);
        return mv;
    }

    @GetMapping("/create")
    public ModelAndView showCreateCustomerForm(){
        ModelAndView mv = new ModelAndView("/customer/create");
        mv.addObject("customers", new Customer());
        return mv;
    }

    @PostMapping("/create")
    public ModelAndView saveCustomer(@ModelAttribute("customers") Customer customer){
        customerService.save(customer);
        ModelAndView mv = new ModelAndView("/customer/create");
        mv.addObject("customers", new Customer());
        return mv;
    }

    @GetMapping("/edit/{id}")
    public ModelAndView showEditForm(@PathVariable("id") Long id){
        Customer customer = customerService.findOne(id);
        ModelAndView mv = new ModelAndView("/customer/edit");
        return mv;
    }
}
