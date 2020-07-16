package com.hotelmanager.repositories;

import com.hotelmanager.models.account.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


public interface RoleRepository extends CrudRepository<Role,Long> {
}
