package com.ib.service.impl;

import com.ib.dao.AccountDao;
import com.ib.model.Account;
import com.ib.service.AccountManager;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * Implementation of UserManager interface.
 *
 * @author <a href="mailto:matt@raibledesigns.com">Matt Raible</a>
 */
@Service("accountManager")
public class AccountManagerImpl extends GenericManagerImpl<Account, Long> implements AccountManager {
    private AccountDao accountDao;


    public AccountManagerImpl(AccountDao accountDao) {
        super(accountDao);
        this.accountDao = accountDao;
    }

    public List<Account> findByAccountType(String accountType) {
        return accountDao.findByAccountType(accountType);
    }
}
