package com.hotelmanager.repositories;

import com.hotelmanager.models.account.Role;
import org.springframework.data.repository.CrudRepository;

public interface RoleRepository extends CrudRepository<Role,Long> {
}
