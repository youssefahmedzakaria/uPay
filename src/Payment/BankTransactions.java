package Payment;

import User.*;

public class BankTransactions {
    BankUser bankUser;

    // Constructor for Payment.BankTransactions class
    public BankTransactions(BankUser bankUser) {
        this.bankUser = bankUser;

    }

    public void transferToBankAccountCode(String accountCode, double amount, int pin) {
        // Override this method if there's additional logic specific to bank transactions
        if (pin == bankUser.getPin()) {
            if (bankUser.inquireBalance() >= amount) {
                bankUser.setNewBalance(bankUser.inquireBalance() - amount);
                System.out.println(amount + " transferred successfully to " + accountCode + ". Your balance: " + bankUser.inquireBalance());
            } else {
                System.out.println("Your balance is insufficient.");
            }
        } else {
            System.out.println("Invalid Pin");
        }
    }

    public static void main(String[] args) {
        User user = new BankUser("username", "password", 123456789, 1234, "bank", "123456789", "12/12/2020", "123456789", new Bank("bank", 100000));
        BankTransactions bankTransactions = new BankTransactions((BankUser) user);
        bankTransactions.transferToBankAccountCode("123456789", 1000, 1234);
    }
}
