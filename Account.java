public class Account {
    private String accountNumber;
    private String holderName;
    private double balance;

    public Account(String accountNumber, String holderName) {
        this.accountNumber = accountNumber;
        this.holderName = holderName;
        this.balance = 0.0;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getHolderName() {
        return holderName;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        }
    }

    public boolean withdraw(double amount) {
        if (amount > 0 && balance >= amount) {
            balance -= amount;
            return true;
        }
        return false;
    }

    public boolean transfer(Account toAccount, double amount) {
        if (withdraw(amount)) {
            toAccount.deposit(amount);
            return true;
        }
        return false;
    }
}
