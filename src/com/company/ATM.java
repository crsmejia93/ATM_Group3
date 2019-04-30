package com.company;

import java.util.ArrayList;
import java.util.Scanner;


public class ATM extends Account{
    //This global ArrayList will contain all the Account objects
    private ArrayList<Account> accounts;

    public ATM(){
        accounts = new ArrayList<>();
    }

    public void runATM(){
        String accntNum, answer = "";
        int count = 0;//This counter will determine how many times someone can enter their pin
        float amount;//This variable will be used for storing an amount to withdraw or deposit
        int option;//This will be used to determine the options for the ATM
        float increase=0, decrease=0;//This variables will keep track of the amount deposited or withdrawn
        Scanner input = new Scanner(System.in);

        System.out.print("Please enter your account number: ");
        accntNum = input.nextLine();
        //This for loop will iterate through each account in accounts ArrayList
        for(Account account: accounts) {
            //This if-statement will check if the account number enter matches any account in the ArrayList
            //the account number will always be correct just for the sake of the simulator
            if (account.getAccntNum().equalsIgnoreCase(accntNum)) {
                while (count < 3) {
                    System.out.print("Enter your PIN: ");
                    int pin = input.nextInt();
                    if (account.getPIN() == pin) {
                        while(!answer.equalsIgnoreCase("n")){
                            System.out.print("Please choose options: 1-Withdraw | 2-Deposit | 3-Check Balance: ");
                            option = input.nextInt();
                            switch (option){
                                case 1://This fist case will run if the option entered is 1
                                    System.out.print("Enter amount to withdraw: ");
                                    amount = input.nextInt();
                                    //the amount to be withdrawn will be passed here, along side with the acount
                                    decrease += amount;//this will allow us to keep track of amount withdrawn
                                    withdraw(amount, account);
                                    break;
                                case 2://This fist case will run if the option entered is 2
                                    System.out.print("Enter amount to deposit: ");
                                    amount = input.nextInt();
                                    increase += amount;//this will allow us to keep track of amount deposited
                                    deposit(amount, account);
                                    break;
                                case 3://This fist case will run if the option entered is 3
                                    checkBalance(account);
                                    break;
                            }
                            input.nextLine();//This will just clear the input buffer
                            System.out.print("Will you like to do something else: (y/n)");
                            answer=input.nextLine();
                        }//end-while
                        //This will print out all the transaction history.
                        //we will pass the account, the amount deposited and withdrawn, if any
                        transactions(account, increase, decrease);
                        //This break statement will only run if there are no more transactions needed
                        //it will break out of the parent while-loop
                        break;
                    } else if(count <2){
                        System.out.println("Wrong PIN, please try again");
                    }else{
                        System.out.println("The account has been locked, please contact customer service.");
                    }
                    count++;//counter
                }//end-while
            }//end-if
        }//end-for
    }//end-runATM

    //This method just adds an account to the accounts ArrayList
    public void addAccount(Account accnt){
        accounts.add(accnt);
    }
    //This method will deposit the amount in the parameter to the account passed in the parameter
    private void deposit(float amount, Account accnt){
        float balance=0;
        if(accounts.contains(accnt)){
            balance = accnt.getBalance();
            //This will add the amount entered to the balance
            balance +=amount;
            accnt.setBalance(balance);
        }
    }
    //This method will withdraw the amount in the parameter to the account passed in the parameter
    private float withdraw(float amount, Account accnt){
        float balance=0;
        if(accounts.contains(accnt)){
            balance = accnt.getBalance();
            //This will subtract the amount entered form the balance
            balance -=amount;
            accnt.setBalance(balance);//this will set the new balance to the account
        }
        return balance;
    }
    //This will check the balance of the specified account if its in the accounts ArrayList
    private void checkBalance(Account accnt){
        if(accounts.contains(accnt)){
            System.out.printf("Current balance: $%,.2f\n",accnt.getBalance());
        }
    }
    //As you can see this method will only print out the history of the transactions
    //and the remaining balance
    private void transactions(Account accnt, float increase, float decrease){
        System.out.println("\nRecent Transactions for "+accnt.getUserName());
        System.out.println("__________________________");
        System.out.printf("Recent Deposit: $%,.2f\n", increase);
        System.out.printf("Recent Withdrawn: $%,.2f\n", decrease);
        System.out.printf("Remaining Balance: $%,.2f\n", accnt.getBalance());
    }
}
