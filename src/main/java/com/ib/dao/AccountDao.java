package com.ib.dao;

import com.ib.model.Account;

import java.util.List;

/**
 * Created by IMAM on 12/17/14.
 */
public interface AccountDao extends GenericDao<Account, Long> {
    public List<Account> findByAccountType(String accountType);
}
