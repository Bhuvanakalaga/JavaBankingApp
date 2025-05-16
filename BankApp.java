import java.util.*;

public class BankApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Bank bank = new Bank();

        while (true) {
            System.out.println("\n--- BANKING SYSTEM ---");
            System.out.println("1. Create Account\n2. Deposit\n3. Withdraw\n4. Transfer\n5. Mini Statement\n6. Exit");
            System.out.print("Choose option: ");
            int choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter Account Number: ");
                    String accNo = sc.nextLine();
                    System.out.print("Enter Holder Name: ");
                    String name = sc.nextLine();
                    bank.createAccount(accNo, name);
                    System.out.println("Account Created.");
                    break;

                case 2:
                    System.out.print("Enter Account Number: ");
                    accNo = sc.nextLine();
                    Account acc = bank.getAccount(accNo);
                    if (acc != null) {
                        System.out.print("Enter Amount: ");
                        double amt = sc.nextDouble();
                        acc.deposit(amt);
                        bank.recordTransaction(accNo, "deposit", amt);
                        System.out.println("Amount Deposited.");
                    } else {
                        System.out.println("Account not found.");
                    }
                    break;

                case 3:
                    System.out.print("Enter Account Number: ");
                    accNo = sc.nextLine();
                    acc = bank.getAccount(accNo);
                    if (acc != null) {
                        System.out.print("Enter Amount: ");
                        double amt = sc.nextDouble();
                        if (acc.withdraw(amt)) {
                            bank.recordTransaction(accNo, "withdraw", amt);
                            System.out.println("Amount Withdrawn.");
                        } else {
                            System.out.println("Insufficient balance.");
                        }
                    } else {
                        System.out.println("Account not found.");
                    }
                    break;

                case 4:
                    System.out.print("Enter From Account: ");
                    String from = sc.nextLine();
                    System.out.print("Enter To Account: ");
                    String to = sc.nextLine();
                    System.out.print("Enter Amount: ");
                    double amt = sc.nextDouble();

                    Account fromAcc = bank.getAccount(from);
                    Account toAcc = bank.getAccount(to);
                    if (fromAcc != null && toAcc != null) {
                        if (fromAcc.transfer(toAcc, amt)) {
                            bank.recordTransaction(from, "transfer", amt);
                            bank.recordTransaction(to, "receive", amt);
                            System.out.println("Transfer Successful.");
                        } else {
                            System.out.println("Transfer Failed. Insufficient funds.");
                        }
                    } else {
                        System.out.println("Account(s) not found.");
                    }
                    break;

                case 5:
                    System.out.print("Enter Account Number: ");
                    accNo = sc.nextLine();
                    System.out.println("Mini Statement:");
                    bank.showMiniStatement(accNo);
                    break;

                case 6:
                    System.out.println("Thank you for using our banking app!");
                    sc.close();
                    System.exit(0);
            }
        }
    }
}
