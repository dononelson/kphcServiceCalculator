package com.kaiser.controller.response;

import java.util.Date;

public class DateResult {
    private Date date;
    private double amount;

    public double getAmount() {
        return amount;
    }

    public void setAmount(final double amount) {
        this.amount = amount;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(final Date date) {
        this.date = date;
    }
}