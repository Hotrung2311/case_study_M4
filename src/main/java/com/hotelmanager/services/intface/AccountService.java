package com.hotelmanager.services.intface;

import com.hotelmanager.models.account.Account;
import com.hotelmanager.services.IService;

public interface AccountService extends IService<Account> {
    Account findAccountByUsername(String username);
}
