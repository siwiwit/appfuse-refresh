package com.ib.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by IMAM on 12/17/14.
 */
@Entity
public class AccountStatement extends BaseObject {
    private Long id;
    private Date transactionDate;
    private String description;
    private String branch;
    private BigDecimal amount;
    private String dbCr;
    private BigDecimal balance;

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name="transaction_date")
    public Date getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(Date transactionDate) {
        this.transactionDate = transactionDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    @Column(name="db_cr", length=20)
    public String getDbCr() {
        return dbCr;
    }

    public void setDbCr(String dbCr) {
        this.dbCr = dbCr;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AccountStatement account = (AccountStatement) o;

        if (transactionDate != null ? !transactionDate.equals(account.transactionDate) : account.transactionDate != null)
            return false;
        if (description != null ? !description.equals(account.description) : account.description != null) return false;
        if (balance != null ? !balance.equals(account.balance) : account.balance != null) return false;
        if (branch != null ? !branch.equals(account.branch) : account.branch != null) return false;
        if (id != null ? !id.equals(account.id) : account.id != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (transactionDate != null ? transactionDate.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (balance != null ? balance.hashCode() : 0);
        result = 31 * result + (branch != null ? branch.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", transactionDate='" + transactionDate + '\'' +
                ", description='" + description + '\'' +
                ", balance=" + balance +
                ", branch='" + branch + '\'' +
                '}';
    }
}
