package presentations;
import java.util.Scanner;

import models.Timer;
import services.CreateAccount;
import services.InputValidity;
import services.LoginSearch;

class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean running = true;
        System.out.println("Hello there!\nWelcome to Don Pablo's El PAXO Bank.");
        while (running){
            Timer.delayTimer();
            System.out.println("What are you here for?");
            System.out.println("1. Create an account\n2. Login to an account\n3. Exit");
            int arg = InputValidity.isIntValid(sc);
            sc.nextLine();
        switch (arg) {
            case 1 -> {
                try {
                    System.out.println("Processing");
                    Timer.delayTimer();
                    CreateAccount.createAccountRequest(sc);
                    
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
                }
                
            case 2 -> {
                try {
                    LoginSearch.loginRequest(sc); 
                    
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
                }
                
            case 3 -> {
                System.out.println("Goodbye!");
                running = false;
                }
                
            default -> System.out.println("Invalid Number. Try again:");
        }
        
    }
  }
}