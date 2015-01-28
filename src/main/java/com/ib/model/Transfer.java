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
public class Transfer extends BaseModel {
    private Long id;
    private String transferType;
    private Account senderAccount;
    private String destinationAccountNumber;
    private String destinationAccountName;
    private String destinationBankCode;
    private String destinationBankName;
    private BigDecimal amount;
    private String news;
    private Date transferTime;

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name="transfer_type")
    public String getTransferType() {
        return transferType;
    }

    public void setTransferType(String transferType) {
        this.transferType = transferType;
    }

    @Embedded
    @IndexedEmbedded
    @Column(name="sender_account")
    public Account getSenderAccount() {
        return senderAccount;
    }

    public void setSenderAccount(Account senderAccount) {
        this.senderAccount = senderAccount;
    }

    @Column(name="destination_account_number")
    public String getDestinationAccountNumber() {
        return destinationAccountNumber;
    }

    public void setDestinationAccountNumber(String destinationAccountNumber) {
        this.destinationAccountNumber = destinationAccountNumber;
    }

    @Column(name="destination_account_name")
    public String getDestinationAccountName() {
        return destinationAccountName;
    }

    public void setDestinationAccountName(String destinationAccountName) {
        this.destinationAccountName = destinationAccountName;
    }

    @Column(name="destination_bank_code")
    public String getDestinationBankCode() {
        return destinationBankCode;
    }

    public void setDestinationBankCode(String destinationBankCode) {
        this.destinationBankCode = destinationBankCode;
    }

    @Column(name="destination_bank_name")
    public String getDestinationBankName() {
        return destinationBankName;
    }

    public void setDestinationBankName(String destinationBankName) {
        this.destinationBankName = destinationBankName;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Column(name="transaction_date")
    public Date getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(Date transactionDate) {
        this.transactionDate = transactionDate;
    }

    public String getNews() {
        return news;
    }

    public void setNews(String news) {
        this.news = news;
    }

    public Date getTransferTime() {
        return transferTime;
    }

    public void setTransferTime(Date transferTime) {
        this.transferTime = transferTime;
    }

    @Transient
    public String getStrTransactionDate() {

        String sDate = DateUtil.getDateTime(DateUtil.getDateTimePattern(), getTransactionDate());
        return sDate;
    }

    public void setStrTransactionDate(String strTransactionDate) {
        this.strTransactionDate = strTransactionDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Transfer account = (Transfer) o;

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
        return "Transfer {" +
                "id=" + id +
                ", transactionDate='" + transactionDate + '\'' +
                '}';
    }
}
