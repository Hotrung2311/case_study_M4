package com.hotelmanager.services;

import java.util.List;

public interface IService<T>{
    List<T> findAll();
    T findOne(Long id);
    T save(T model);
    T delete (Long id);
}
