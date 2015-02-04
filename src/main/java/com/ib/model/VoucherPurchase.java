package com.ib.model;

/**
 * Created by USER on 1/27/15.
 */
public class VoucherPurchase extends Purchase {
    private String operator;
    private String phoneNumber;
    private String denomination;

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getDenomination() {
        return denomination;
    }

    public void setDenomination(String denomination) {
        this.denomination = denomination;
    }
}
