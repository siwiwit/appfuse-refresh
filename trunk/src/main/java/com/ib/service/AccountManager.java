package com.ib.service;

import com.ib.model.Account;

import java.util.List;

/**
 * Created by IMAM on 12/17/14.
 */
public interface AccountManager extends GenericManager<Account, Long> {
    List<Account> findByAccountType(String accountType);
}
