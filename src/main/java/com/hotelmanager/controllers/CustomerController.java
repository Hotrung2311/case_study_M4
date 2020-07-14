package com.hotelmanager.controllers;

import com.hotelmanager.models.customer.Customer;
import com.hotelmanager.services.intface.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/customers")
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
        ModelAndView mv = new ModelAndView("/customer/save");
        mv.addObject("action","Create new customer");
        mv.addObject("customer", new Customer());
        return mv;
    }

    @PostMapping("/save")
    public ModelAndView saveCustomer(@ModelAttribute("customer") Customer customer){
        customerService.save(customer);
        ModelAndView mv = new ModelAndView("/customer/save");
        mv.addObject("customer", customer);
        mv.addObject("message","Saving is successful");
        return mv;
    }

    @GetMapping("/edit/{id}")
    public ModelAndView showEditForm(@PathVariable("id") Long id){
        Customer customer = customerService.findOne(id);
        ModelAndView mv = new ModelAndView("/customer/save");
        mv.addObject("action","Edit customer "+customer.getLastName());
        mv.addObject("customer",customer);
        return mv;
    }
    @GetMapping("/delete/{id}")
    public ModelAndView delete(@PathVariable("id") Long id){
        customerService.delete(id);
        ModelAndView mv = new ModelAndView("/customer/list");
        mv.addObject("customers",customerService.findAll());
        mv.addObject("message","Removed !!!");
        return mv;
    }
}
