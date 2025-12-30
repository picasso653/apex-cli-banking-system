package services;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;

public class InputValidity {
    public static int  isIntValid(Scanner sc){
        int arg = 0;
        boolean valid = false;

            while (!valid) {

                if (sc.hasNextInt()) {
                    arg = sc.nextInt();
                    valid = true;
                } else {
                    String badInput = sc.next(); 
                    System.out.println("Invalid argument: " + badInput);
                    System.out.print("Please enter a valid number: ");
                }
            }
            return arg;
    }

    public static double isDoubleValid(Scanner sc){
        double arg = 0;
        boolean valid = false;

        while (!valid) {
            if (sc.hasNextDouble()) {
                arg = sc.nextDouble();
                valid = true;
            } else {
                String badInput = sc.next(); 
                System.out.println("Invalid argument: " + badInput);
                System.out.print("Please enter a valid number: ");
            }}
            BigDecimal bd = BigDecimal.valueOf(arg);
            
            return bd.setScale(2, RoundingMode.CEILING).doubleValue();
    }


    public static String isStringValid(Scanner sc){
        String arg = "";
        boolean valid = false;

        while (!valid) {
            arg = sc.nextLine();
            if (!arg.isEmpty() && !arg.isBlank() &&arg.matches("^[a-zA-Z -]+$")) {
                valid = true;
            } else {
                System.out.print("Please enter a valid string: ");
            }
        }
        return arg;
    }

    public static String isIDValid (Scanner sc){
        String arg = "";
        boolean valid = true;

        while (valid) {
            arg = sc.nextLine();
            if (!arg.isEmpty() && !arg.isBlank() &&arg.matches("^(SA-|CA-)\\d{8}$")) {
                valid = false;
            } else {
                System.out.print("Please enter a valid ID: ");
            }
        }
        return arg;
    }

    public static String isPINValid(Scanner sc){
        String arg = "";
        boolean valid = true;

        while (valid) {
            arg = sc.nextLine();
            if (!arg.isEmpty() && !arg.isBlank() &&arg.matches("\\d{4}")) {
                valid = false;
            } else {
                System.out.print("Invalid PIN! Please enter a valid 4-digit PIN: ");
            }
         }
        return arg;
    }
}
