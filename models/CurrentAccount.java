package models;

import exceptionhandlers.InsufficientFundsException;

public class CurrentAccount extends Account{
    private final double accountLimit = 500000.0;
    private final double interestRate = 0.01;


    public CurrentAccount(String accountName, String accountNumber, double balance, String pin) {
        super(accountName, accountNumber, balance, pin);

    }

    
    
    @Override
    public void deposit(double amount){
        Timer.delayTimer();
        if (amount > 0){
            if (balance + amount <= accountLimit){
                balance += amount;
                id++;
                transactionhistory.add(new Transactions(Integer.toString(id), TransactionType.Credit, amount));
                System.out.println("An amount of " + amount + " has been deposited. New balance: " + balance);
            } else {
                throw new IllegalArgumentException("Deposit amount exceeds account limit.");
            }

            } else {
            throw new IllegalArgumentException("Deposit amount must be positive.");
        }
    }

    

    
    @Override
    public void withdraw(double amount) throws InsufficientFundsException{
        Timer.delayTimer();
       if (amount > 0){
        if (balance - amount >= -500){
            balance -= amount;
            if (balance < 0){
                System.out.println("You have taken a loan of " + balance +" cedis.\nThis is due to the fact that the amount withdrawn exceeded the account balance.");
            }
            id++;
            transactionhistory.add(new Transactions(Integer.toString(id), TransactionType.Debit, amount));
            System.out.println("An amount of " + amount + " has been withdrawn. Remaining balance: " + balance);
        } else {
            throw new InsufficientFundsException("Insufficient funds.");
        }
    }
         else {
            throw new IllegalArgumentException("Withdrawal amount must be positive.");
        }
    }
    
    @Override
    public double calculateInterest(){
        return balance * interestRate;
    }
}
