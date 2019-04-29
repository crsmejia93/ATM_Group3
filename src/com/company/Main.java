package com.company;

import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);

        Account acct1 = new Account();
        acct1.setUserName("Cesar Mejia");
        acct1.setBalance(1000);
        acct1.setAccntNum("123456");
        acct1.setPIN(1234);

        ATM atm = new ATM();
        atm.addAccount(acct1);
        atm.runATM();

    }
}
