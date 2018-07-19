package com.example.demo.entity;


import java.io.Serializable;

public class Result implements Serializable {

    private String amount;
    private String rate;
    private String from;
    private String to;

    public Result() {
    }

    public Result(String amount, String rate, String from, String to) {
        this.amount = amount;
        this.rate = rate;
        this.from = from;
        this.to = to;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getRate() {
        return rate;
    }

    public void setRate(String rate) {
        this.rate = rate;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

}

