package com.hotelmanager.services.Impl;

import com.hotelmanager.models.customer.Customer;
import com.hotelmanager.repositories.CustomerRepository;
import com.hotelmanager.services.intface.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public List<Customer> findAll() {
        return (List<Customer>) customerRepository.findAll();
    }

    @Override
    public Customer findOne(Long id) {
        return customerRepository.findById(id).get();
    }

    @Override
    public Customer save(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public Customer delete(Long id) {
        customerRepository.deleteById(id);
        return null;
    }
}
