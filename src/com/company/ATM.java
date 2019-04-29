package com.company;

import java.util.ArrayList;
import java.util.Scanner;


public class ATM extends Account{
    private ArrayList<Account> accounts;

    public ATM(){
        accounts = new ArrayList<>();
    }

    public void runATM(){
        String accntNum;
        int count = 0;
        Scanner input = new Scanner(System.in);
        System.out.print("Please enter your account number: ");
        accntNum = input.nextLine();

        for(Account account: accounts) {
            if (account.getAccntNum().equalsIgnoreCase(accntNum)) {
                while (count < 3) {
                    System.out.print("Enter your PIN: ");
                    int pin = input.nextInt();
                    if (account.getPIN() == pin) {
                        System.out.println(checkBalance(account));
                        break;
                    } else {
                        System.out.println("Wrong PIN, please try again");
                    }
                    count++;
                }
            }
        }
    }

    public void addAccount(Account accnt){
        accounts.add(accnt);
    }

    public void deposit(long balance, Account accnt){
        if(accounts.contains(accnt)){
            accnt.setBalance(balance);
        }
    }

    public long withdraw(Account accnt){
        long balance=0;
        if(accounts.contains(accnt)){
            balance = accnt.getBalance();
        }
        return balance;
    }

    public String checkBalance(Account accnt){
        String balance="";
        if(accounts.contains(accnt)){
            balance = "Current balance: "+accnt.getBalance();
        }
        return balance;
    }

    public void transactions(Account accnt){
        System.out.println("Recent Transactions");
        System.out.printf("Recent Withdraw: %s\n", accnt.getBalance());
        System.out.printf("Remaining Balance: %s\n", accnt.getBalance());
    }
}
