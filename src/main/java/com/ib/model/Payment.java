package com.ib.model;

import com.ib.util.DateUtil;
import org.hibernate.search.annotations.IndexedEmbedded;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by IMAM on 12/17/14.
 */
@Entity
public class Payment extends BaseModel {
    private Long id;
    private BigDecimal amount;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Payment account = (Payment) o;

        if (transactionDate != null ? !transactionDate.equals(account.transactionDate) : account.transactionDate != null)
            return false;
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
        return "Payment {" +
                "id=" + id +
                ", transactionDate='" + transactionDate + '\'' +
                '}';
    }
}
