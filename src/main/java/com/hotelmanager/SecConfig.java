package com.hotelmanager;

import com.hotelmanager.services.Impl.AccountServiceImpl;
import com.hotelmanager.services.Impl.BookingServiceImpl;
import com.hotelmanager.services.Impl.InternetBookingServiceImpl;
import com.hotelmanager.services.Impl.RoleServiceImpl;
import com.hotelmanager.services.intface.AccountService;
import com.hotelmanager.services.intface.BookingService;
import com.hotelmanager.services.intface.InternetBookingService;
import com.hotelmanager.services.intface.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    AccountService accountService;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService((UserDetailsService) accountService)
                .passwordEncoder(new BCryptPasswordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().antMatchers("/").permitAll()
                .antMatchers("/test/**").access("hasAnyRole('ROLE_Admin')")
                .and().formLogin()
                .and().csrf().disable()
        ;
    }
    @Bean
    public RoleService roleService(){
        return new RoleServiceImpl();
    }
    @Bean
    public AccountService accountService(){
        return new AccountServiceImpl();
    }
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
    @Bean
    public BookingService bookingService(){
        return  new BookingServiceImpl();
    }
    @Bean
    public InternetBookingService internetBookingService(){
        return new InternetBookingServiceImpl();
    }
}
