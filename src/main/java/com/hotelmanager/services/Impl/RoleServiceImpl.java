package com.hotelmanager.services.Impl;

import com.hotelmanager.models.account.Role;
import com.hotelmanager.repositories.RoleRepository;
import com.hotelmanager.services.intface.RoleService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleRepository roleRepository;

    @Override
    public List<Role> findAll() {
        return (List<Role>) roleRepository.findAll();
    }

    @Override
    public Role findOne(Long id) {
        return roleRepository.findById(id).get();
    }

    @Override
    public Role save(Role model) {
        return roleRepository.save(model);
    }

    @Override
    public Role delete(Long id) {
        roleRepository.delete(findOne(id));
        return findOne(id);
    }
}
