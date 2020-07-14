package com.hotelmanager.services.Impl;

import com.hotelmanager.models.account.Account;
import com.hotelmanager.repositories.AccountRepository;
import com.hotelmanager.services.intface.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.ArrayList;
import java.util.List;

public class AccountServiceImpl implements AccountService, UserDetailsService {
    @Autowired
    AccountRepository accountRepository;
    @Override
    public Account findAccountByUsername(String username) {
        return accountRepository.findAccountByUsername(username) ;
    }

    @Override
    public List<Account> findAll() {
        return (List<Account>) accountRepository.findAll();
    }

    @Override
    public Account findOne(Long id) {
        return accountRepository.findById(id).get();
    }

    @Override
    public Account save(Account model) {
        return accountRepository.save(model);
    }

    @Override
    public Account delete(Long id) {
        accountRepository.delete(findOne(id));
        return findOne(id);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Account account = findAccountByUsername(username);
        if(account == null)
            throw new UsernameNotFoundException("Not found your username");
        List<GrantedAuthority> roleList = new ArrayList<>();
        roleList.add( new SimpleGrantedAuthority(account.getRole().getName()));
        return new User(account.getUsername(),account.getPassword(),roleList);
    }
}
