package models;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

import exceptionhandlers.InsufficientFundsException;
import services.InputValidity;

public abstract class Account implements Authenticatable {
    final private String accountName;
    final private String accountNumber;
    protected int  id;
    protected double balance;
    protected String pin;
    protected List<Transactions> transactionhistory = new ArrayList<>();

    public Account(String accountName, String accountNumber, double balance, String pin) {
        this.accountName = accountName;
        this.accountNumber = accountNumber;
        this.pin = pin;
        this.balance = balance;
        this.id = 0;
        
    }
    
    public abstract void deposit(double amount);
    public abstract void withdraw(double amount) throws InsufficientFundsException;
    public abstract double calculateInterest();


    public String getAccountName() {
        return accountName;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        Timer.delayTimer();
        return balance;
    }

    @Override
    public void verifyPIN(Scanner sc){
        System.out.println("Enter your 4-digit PIN:");
        String input = InputValidity.isPINValid(sc);
        if (pin.equals(input)){
            
            System.out.println("Login successful!");
            
            

        } else {
            throw new IllegalArgumentException("Invalid PIN");
        }

    }

    public void getTransactionHistory(){
        if (transactionhistory.isEmpty()) {
            System.out.println("No transactions found.");
            
        } else {
            try {
                transactionhistory.stream()
            .sorted(Comparator.comparing((Transactions t)->t.getTimestamp()).reversed()) 
            .forEach(Transactions::getTransaction);
            } catch (Exception e) {
                System.err.println("There's an error: "+e.getMessage());
            }
        }
        
    }

}
