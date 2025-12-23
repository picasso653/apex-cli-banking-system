
import java.util.Scanner;

public class LoginSearch {
    public static void  loginRequest(Scanner sc){
        System.out.println("Enter your account number:");
        String accountNumber = InputValidity.isIDValid(sc);
        try {
            Account account = BankDB.getAccount(accountNumber);
            if (account == null){
                throw new AccountNotFoundException("Account not found");
            }else {
                account.verifyPIN(sc);
                UserDashboard.openUserDashboard(account, sc);
            }
        
        
        
        } catch (AccountNotFoundException e) {
            System.out.println(e.getMessage());
        }
        
        
        
    }

}
