package com.example.CarDealer.Models;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

import java.util.Date;

@Entity
public class SalesModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int saleid;

    @JsonProperty("carid")
    private int carid;

    @JsonProperty("buyerid")
    private int buyerid;

    @Temporal(TemporalType.TIMESTAMP)
    private Date sale_date = new Date();

    @JsonProperty("amount")
    private double amount;

    @JsonProperty("paymentStatus")
    private int paymentStatus;

    public SalesModel() {
    }
    public SalesModel(int saleid, int carid, int buyerid, Date sale_date, double amount, int paymentStatus) {
        this.saleid = saleid;
        this.carid = carid;
        this.buyerid = buyerid;
        this.sale_date = sale_date;
        this.amount = amount;
        this.paymentStatus = paymentStatus;
    }

    public int getCarid() {
        return carid;
    }

    public void setCarid(int carid) {
        this.carid = carid;
    }

    public int getSaleid() {
        return saleid;
    }

    public void setSaleid(int saleid) {
        this.saleid = saleid;
    }

    public int getBuyerid() {
        return buyerid;
    }

    public void setBuyerid(int buyerid) {
        this.buyerid = buyerid;
    }

    public Date getSale_date() {
        return sale_date;
    }

    public void setSale_date(Date sale_date) {
        this.sale_date = sale_date;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public int getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(int paymentStatus) {
        this.paymentStatus = paymentStatus;
    }
}
