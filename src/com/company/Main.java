package com.company;

import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        //Here we are just declaring the accounts that will be accessed by the
        //through the ATM
        Account acct1 = new Account();
        acct1.setUserName("Yulia Romanova");
        acct1.setBalance(100000);
        acct1.setAccntNum("654321");
        acct1.setPIN(4321);
        Account acct2 = new Account();
        acct2.setUserName("Michael Asammoah");
        acct2.setBalance(2000);
        acct2.setAccntNum("678901");
        acct2.setPIN(6789);
        Account acct3 = new Account();
        acct3.setUserName("Cesar Mejia");
        acct3.setBalance(1000);
        acct3.setAccntNum("123456");
        acct3.setPIN(1234);

        ATM atm = new ATM();
        atm.addAccount(acct1);
        atm.addAccount(acct2);
        atm.addAccount(acct3);
        atm.runATM();

    }
}
