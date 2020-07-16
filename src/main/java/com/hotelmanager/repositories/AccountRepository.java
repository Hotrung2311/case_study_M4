package com.hotelmanager.repositories;

import com.hotelmanager.models.account.Account;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

public interface AccountRepository extends CrudRepository<Account,Long> {
    Account findAccountByUsername(String username);
}
