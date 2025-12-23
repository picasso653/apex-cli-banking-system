import java.util.HashMap;
import java.util.Map;



public class BankDB {
    private final static Map<String, Account> accounts = new HashMap<>();
    static {
        accounts.put("SA-12345678", new SavingsAccount("Don Pablo", "SA-12345678", 1000.0, "1985"));
        accounts.put("CA-87654321", new CurrentAccount("Another Don", "CA-87654321", 500.0, "2002"));
    }

    public static void addAccount(Account account){
        accounts.put(account.getAccountNumber(), account);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        System.out.println("Account created successfully!");
        System.out.println("Here's your account number:\n"+ account.getAccountNumber());
    }

    public static Account getAccount(String accountNumber){
        return accounts.get(accountNumber);
    }

}
