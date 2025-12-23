
import java.time.LocalDateTime;

public class Transactions {
    private final String transactionID;
    private final TransactionType transactionType;
    private final double amount;
    private LocalDateTime timestamp;

    public Transactions(String transactionID, TransactionType transactionType, double amount) {
        this.transactionID = transactionID;
        this.transactionType = transactionType;
        this.amount = amount;
        this.timestamp = LocalDateTime.now();
    }


    public String getTransactionID() {
        if (transactionType == TransactionType.Credit){
            return "cre-" + transactionID;
        } else {
            return "deb-" + transactionID;
        }
    }


    


    public LocalDateTime getTimestamp() {
        return timestamp;
    }


    public void setTimestamp() {
        timestamp = LocalDateTime.now();
    }


    public TransactionType getTransactionType() {
        return transactionType;
    }


    public void getTransaction(){
        System.out.println("Transaction ID: " + getTransactionID());
        System.out.println("Transaction Type: " + transactionType);
        System.out.println("Amount: " + amount);
        System.out.println("Timestamp: " + getTimestamp());

    }
}
