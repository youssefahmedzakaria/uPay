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
            if (bankUser.checkBankBalance() >= amount) {
                bankUser.setNewBankBalance(bankUser.checkBankBalance() - amount);
                System.out.println(amount + " transferred successfully to " + accountCode + ". Your balance: " + bankUser.checkBankBalance());
            } else {
                System.out.println("Your balance is insufficient.");
            }
        } else {
            System.out.println("Invalid Pin");
        }
    }

    public static void main(String[] args) {
        BankUser bankUser = new BankUser("ahmed", "1234", 1000, 1234, User.userType.BankUser, "CIB", 123456789, "12/22");
        BankTransactions bankTransact = new BankTransactions(bankUser);
        bankTransact.transferToBankAccountCode("123456789", 100, 1233);

    }
}
