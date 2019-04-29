package com.company;

public class Account {
    private String accntNum;
    private String userName;
    private long balance;
    private int PIN;


    public String getAccntNum() {
        return accntNum;
    }

    public void setAccntNum(String accntNum) {
        this.accntNum = accntNum;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public long getBalance() {
        return balance;
    }

    public void setBalance(long balance) {
        this.balance = balance;
    }

    public int getPIN() {
        return PIN;
    }

    public void setPIN(int PIN) {
        this.PIN = PIN;
    }
}
