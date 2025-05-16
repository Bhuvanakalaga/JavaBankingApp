import java.time.LocalDateTime;

public class Transaction {
    private String accountNumber;
    private String type; // deposit, withdraw, transfer
    private double amount;
    private LocalDateTime timestamp;

    public Transaction(String accountNumber, String type, double amount) {
        this.accountNumber = accountNumber;
        this.type = type;
        this.amount = amount;
        this.timestamp = LocalDateTime.now();
    }

    public String toString() {
        return timestamp + " - " + type.toUpperCase() + ": " + amount + " (Account: " + accountNumber + ")";
    }
}
