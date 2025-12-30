package presentations;

import java.util.Scanner;
import models.Account;
import models.Timer;
import services.InputValidity;



public class UserDashboard {
    @SuppressWarnings("UseSpecificCatch")
    public static void openUserDashboard(Account account, Scanner sc) {
        boolean loggedin = true;
        System.out.println("Welcome, " + account.getAccountName());
        while (loggedin){
            System.out.println("What would you like to do?");
            Timer.delayTimer();
            System.out.println("1.Check Balance\n2. Deposit\n3. Withdrawal\n4.See Transactions\n5.Calculate Interest\n6.Logout");
            int activity = InputValidity.isIntValid(sc);
            sc.nextLine();
                switch (activity) {
                
                case 1 -> {
                    System.out.println("Your balance is: " + account.getBalance());
                }
                case 2 -> {
                    System.out.println("How much would you like to deposit?");
                    double amount =  InputValidity.isDoubleValid(sc);
                    account.deposit(amount);
                }
                case 3 -> {
                    try {
                        System.out.println("How much would you like to withdraw?");
                        double amount = InputValidity.isDoubleValid(sc);
                        account.withdraw(amount);
                    } catch (Exception ex) {
                        System.out.println(ex.getMessage());
                    }
                }

                case 4 -> account.getTransactionHistory();
                case 5 ->{
                    double interest = account.calculateInterest();
                    Timer.delayTimer();
                    System.out.println("Your interest is: " + interest);
                }
                case 6 -> {
                    System.out.println("logging out");
                    Timer.delayTimer();
                    loggedin = false;
                    System.out.println("logged out successfully! Come back soon!");

                }
                default -> {
                    System.out.println("Invalid Number. Try again:");
                }
            }
        }
    }
}
