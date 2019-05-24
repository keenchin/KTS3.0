package com.karmakoin.kts.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name="kot_ts_exchange_rates", schema = "dbo")
public class ExchangeRateEntity {
    @Id
    @Column(name="exchange_rate_no")
    @JsonIgnore
    private int exchangeRateNo;

    @Column(name="from_currency_code")
    private String fromCurrencyCode;

    @Column(name="to_currency_code")
    private String toCurrencyCode;

    @Column(name="start_date")
    private Date startDate;

    @Column(name="end_date")
    private Date endDate;

    @Column(name="exchange_rate")
    private BigDecimal exchangeRate;

    @Column(name="revision_no")
    @JsonIgnore
    private short revisionNo;

    @Column(name="update_datetime")
    private Date updateTime;

    public int getExchangeRateNo() {
        return this.exchangeRateNo;
    }

    public void setExchangeRateNo(int exchangeRateNo) {
        this.exchangeRateNo = exchangeRateNo;
    }

    public String getFromCurrencyCode() {
        return this.fromCurrencyCode;
    }

    public void setFromCurrencyCode(String currencyCode) {
        this.fromCurrencyCode = currencyCode;
    }

    public String getToCurrencyCode() {
        return this.toCurrencyCode;
    }

    public void setToCurrencyCode(String currencyCode) {
        this.toCurrencyCode =  currencyCode;
    }

    public Date getStartDate() {
        return this.startDate;
    }

    public void setStartDate(Date date) {
        this.startDate = date;
    }

    public Date getEndDate() {
        return this.endDate;
    }

    public void setEndDate(Date date) {
        this.endDate = date;
    }

    public BigDecimal getExchangeRate() {
        return this.exchangeRate;
    }

    public void setExchangeRate(BigDecimal rate) {
        this.exchangeRate = rate;
    }

    public short getRevisionNo() {
        return this.revisionNo;
    }

    public void setRevisionNo(short revisionNo) {
        this.revisionNo = revisionNo;
    }

    public Date getUpdateTime() {
        return this.updateTime;
    }

    public void setUpdateTime(Date dateTime) {
        this.updateTime = dateTime;
    }
}
