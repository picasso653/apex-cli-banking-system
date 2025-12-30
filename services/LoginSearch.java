package services;

import java.util.Scanner;

import models.Account;
import exceptionhandlers.AccountNotFoundException;
import models.BankDB;
import presentations.UserDashboard;

public class LoginSearch {
    public static void  loginRequest(Scanner sc){
        System.out.println("Enter your account number:");
        String accountNumber = InputValidity.isIDValid(sc);
        try {
            Account account = BankDB.getAccount(accountNumber);
            if (account == null){
                throw new AccountNotFoundException("Account not found");
            }else {
                try {
                    account.verifyPIN(sc);
                    UserDashboard.openUserDashboard(account, sc);
                } catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                }
                
            }
        
        
        
        } catch (AccountNotFoundException e) {
            System.out.println(e.getMessage());
        }
        
        
        
    }

}
