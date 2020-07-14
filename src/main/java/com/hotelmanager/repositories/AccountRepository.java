package com.hotelmanager.repositories;

import com.hotelmanager.models.account.Account;
import org.springframework.data.repository.CrudRepository;

public interface AccountRepository extends CrudRepository<Account,Long> {
    Account findAccountByUsername(String username);
}
