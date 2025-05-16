import java.util.*;

public class Bank {
    private List<Account> accounts = new ArrayList<>();
    private List<Transaction> transactions = new ArrayList<>();

    public Account createAccount(String accountNumber, String name) {
        Account acc = new Account(accountNumber, name);
        accounts.add(acc);
        return acc;
    }

    public Account getAccount(String accountNumber) {
        for (Account acc : accounts) {
            if (acc.getAccountNumber().equals(accountNumber)) {
                return acc;
            }
        }
        return null;
    }

    public void recordTransaction(String accNo, String type, double amount) {
        transactions.add(new Transaction(accNo, type, amount));
    }

    public void showMiniStatement(String accountNumber) {
        for (Transaction t : transactions) {
            if (t.toString().contains(accountNumber)) {
                System.out.println(t);
            }
        }
    }
}
