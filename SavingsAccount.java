class SavingsAccount extends Account {
    private final double interestRate;
    private final double withdrawalLimit = 50;
    private int withdrawalCount = 3;



    public SavingsAccount( String accountName, String accountNumber, double balance, String pin) {
        super(accountName, accountNumber, balance, pin);
        this.interestRate = 0.05;
    }

    @Override
    void withdraw(double amount) throws InsufficientFundsException{
        Timer.delayTimer();
        if (withdrawalCount > 0 ){
            if (amount > 0){
                    if (balance - amount >= withdrawalLimit){
                        balance -= amount;
                        id ++;
                        withdrawalCount--;
                        transactionhistory.add(new Transactions(Integer.toString(id), TransactionType.Debit, amount));
                        System.out.println("An amount of " + amount + " has been withdrawn. Remaining balance: " + balance);
                    } else {
                        throw new InsufficientFundsException("Insufficient Funds");
                    }
                } else {
                    throw new IllegalArgumentException("Withdrawal amount must be positive.");
                }
        } else{
            throw new IllegalArgumentException("Withdrawal limit exceeded.");
        }
    }

    @Override
    void deposit(double amount){
        Timer.delayTimer();
        id ++;
        if (amount > 0){
            balance += amount;
            transactionhistory.add(new Transactions(Integer.toString(id), TransactionType.Credit, amount));
            System.out.println("An amount of " + amount + " has been deposited. New balance: " + balance);
        } else {
            throw new IllegalArgumentException("Deposit amount must be positive.");
        }
    }

    @Override
    public double calculateInterest(){
        return balance * interestRate;
    }
}