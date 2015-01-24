package com.ib.model;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * Created by IMAM on 12/17/14.
 */
@Entity
public class AccountStatementSummary extends BaseObject {
    private Long id;
    private BigDecimal startingBalance;
    private BigDecimal totalCredit;
    private BigDecimal totalDebit;
    private BigDecimal endingBalance;

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name="starting_balance")
    public BigDecimal getStartingBalance() {
        return startingBalance;
    }

    public void setStartingBalance(BigDecimal startingBalance) {
        this.startingBalance = startingBalance;
    }

    @Column(name="total_credit")
    public BigDecimal getTotalCredit() {
        return totalCredit;
    }

    public void setTotalCredit(BigDecimal totalCredit) {
        this.totalCredit = totalCredit;
    }

    @Column(name="total_debit")
    public BigDecimal getTotalDebit() {
        return totalDebit;
    }

    public void setTotalDebit(BigDecimal totalDebit) {
        this.totalDebit = totalDebit;
    }

    @Column(name="ending_balance")
    public BigDecimal getEndingBalance() {
        return endingBalance;
    }

    public void setEndingBalance(BigDecimal endingBalance) {
        this.endingBalance = endingBalance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AccountStatementSummary account = (AccountStatementSummary) o;

        if (id != null ? !id.equals(account.id) : account.id != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        return result;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", startingBalance='" + startingBalance + '\'' +
                ", endingBalance='" + endingBalance + '\'' +
                '}';
    }
}
