package com.ib.dao.hibernate;

import com.ib.dao.AccountDao;
import com.ib.model.Account;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by USER on 12/17/14.
 */
@Repository("accountDao")

public class AccountDaoHibernate extends GenericDaoHibernate<Account, Long> implements AccountDao {


    public AccountDaoHibernate() {
        super(Account.class);
    }
    public AccountDaoHibernate(String test) {
        super(Account.class);
    }
    @Override
    public List<Account> findByAccountType(String accountType) {
        return getSession().createCriteria(Account.class).add(Restrictions.eq("accountType", accountType)).list();

    }
}
