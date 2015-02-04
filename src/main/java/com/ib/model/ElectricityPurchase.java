package com.ib.model;

import java.math.BigDecimal;

/**
 * Created by USER on 1/27/15.
 */
public class ElectricityPurchase extends Purchase {
    private String meterNumber;
    private String idPel;
    private String customerName;
    private String tarifDaya;
    private String mlpo;
    private BigDecimal adminBank;
    private BigDecimal materai;
    private BigDecimal ppn;
    private BigDecimal ppj;
    private BigDecimal angsuran;
    private BigDecimal rpStroomToken;
    private Double jumlahKwh;
    private String stroomToken;

    public String getMeterNumber() {
        return meterNumber;
    }

    public void setMeterNumber(String meterNumber) {
        this.meterNumber = meterNumber;
    }

    public String getIdPel() {
        return idPel;
    }

    public void setIdPel(String idPel) {
        this.idPel = idPel;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getTarifDaya() {
        return tarifDaya;
    }

    public void setTarifDaya(String tarifDaya) {
        this.tarifDaya = tarifDaya;
    }

    public String getMlpo() {
        return mlpo;
    }

    public void setMlpo(String mlpo) {
        this.mlpo = mlpo;
    }

    public BigDecimal getAdminBank() {
        return adminBank;
    }

    public void setAdminBank(BigDecimal adminBank) {
        this.adminBank = adminBank;
    }

    public BigDecimal getMaterai() {
        return materai;
    }

    public void setMaterai(BigDecimal materai) {
        this.materai = materai;
    }

    public BigDecimal getPpn() {
        return ppn;
    }

    public void setPpn(BigDecimal ppn) {
        this.ppn = ppn;
    }

    public BigDecimal getPpj() {
        return ppj;
    }

    public void setPpj(BigDecimal ppj) {
        this.ppj = ppj;
    }

    public BigDecimal getAngsuran() {
        return angsuran;
    }

    public void setAngsuran(BigDecimal angsuran) {
        this.angsuran = angsuran;
    }

    public BigDecimal getRpStroomToken() {
        return rpStroomToken;
    }

    public void setRpStroomToken(BigDecimal rpStroomToken) {
        this.rpStroomToken = rpStroomToken;
    }

    public Double getJumlahKwh() {
        return jumlahKwh;
    }

    public void setJumlahKwh(Double jumlahKwh) {
        this.jumlahKwh = jumlahKwh;
    }

    public String getStroomToken() {
        return stroomToken;
    }

    public void setStroomToken(String stroomToken) {
        this.stroomToken = stroomToken;
    }
}
