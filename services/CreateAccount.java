package services;

import java.util.Scanner;

import models.*;


public class CreateAccount {
    private static SavingsAccount createSavingsAccount(String name, double balance, String pin){
        System.out.println("Creating Savings Account");
        Timer.delayTimer();
        System.out.println("Getting the "+balance+" cedis deposit");
        String accountNumber = "SA-" + generateAccountNumber();
        return new SavingsAccount(name, accountNumber, balance, pin);
    }


    private static CurrentAccount createCurrentAccount(String name, String pin){
        String accountNumber = "CA-" + generateAccountNumber();
        return new CurrentAccount(name, accountNumber, 0, pin);
    }

    private static int generateAccountNumber(){
        int min = 10000000;
        int max = 99999999;
        return (int)(Math.random() * (max - min + 1) + min);
    }

    public static void createAccountRequest(Scanner sc){
            System.out.println("Great! Let's first get your name. What is your name");
            System.out.println("First Name: ");
            String firstName = InputValidity.isStringValid(sc);
            System.out.println("Last Name: ");
            String lastName = InputValidity.isStringValid(sc);
            String name = firstName + " " + lastName;
            System.out.println("Good, what type of account you want to create?");
            System.out.println("1. Savings Account(You're required to make a deposit of 50.00 cedis minimum)\n2. Current Account");
            int arg = InputValidity.isIntValid(sc);
            sc.nextLine();

            switch (arg) {
                case 1 -> {
                    System.out.println("How much would you like to deposit?");
                    double balance = InputValidity.isDoubleValid(sc);
                     while (balance < 50.00){
                        System.out.print("You're required to make a deposit of 50.00 cedis minimum.\nHow much would you like to deposit?\n");
                        balance = InputValidity.isDoubleValid(sc);
                     }
                     sc.nextLine();
                     System.out.println("Create a 4-digit pin for your account:");
                     String pin = InputValidity.isPINValid(sc);

                    BankDB.addAccount(createSavingsAccount(name, balance, pin));
                }
                case 2 -> {
                    System.out.println("Create a 4-digit pin for your account:");
                    String pin = InputValidity.isPINValid(sc);
                    BankDB.addAccount(createCurrentAccount(name, pin));
                }
                default -> {
                    throw new IllegalArgumentException("Invalid argument");
                }
            }
        }
    }

