package com.qf.entity;

import java.util.Date;

public class Transfer {

    private Integer uid;
    private Integer cid;
    private Double money;
    private Date creatTime;
    private String comment;
    private String consumType;
    private Double balance;

    public Transfer() {
    }

    public Transfer(Integer uid, Integer cid, Double money, Date creatTime, String comment, String consumType, Double balance) {
        this.uid = uid;
        this.cid = cid;
        this.money = money;
        this.creatTime = creatTime;
        this.comment = comment;
        this.consumType = consumType;
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "Transfer{" +
                "uid=" + uid +
                ", cid=" + cid +
                ", money=" + money +
                ", creatTime=" + creatTime +
                ", comment='" + comment + '\'' +
                ", consumType='" + consumType + '\'' +
                ", balance=" + balance +
                '}';
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }

    public Date getCreatTime() {
        return creatTime;
    }

    public void setCreatTime(Date creatTime) {
        this.creatTime = creatTime;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getConsumType() {
        return consumType;
    }

    public void setConsumType(String consumType) {
        this.consumType = consumType;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }
}
