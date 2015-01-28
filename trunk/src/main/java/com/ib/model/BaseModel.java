package com.ib.model;

import java.util.Date;

/**
 * Created by USER on 12/28/14.
 */
public abstract class BaseModel extends BaseObject {
    protected String status;
    protected Date transactionDate;
    protected String strTransactionDate;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(Date transactionDate) {
        this.transactionDate = transactionDate;
    }

    public String getStrTransactionDate() {
        return strTransactionDate;
    }

    public void setStrTransactionDate(String strTransactionDate) {
        this.strTransactionDate = strTransactionDate;
    }
}
