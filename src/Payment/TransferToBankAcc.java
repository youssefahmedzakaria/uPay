package Payment;
import User.*;
import App.*;
import java.util.ArrayList;
import java.util.Scanner;

public class TransferToBankAcc extends Transferrations {
    private ArrayList<BankUser> listOfBankUser;

    // Constructor for Payment.BankTransactions class
    public TransferToBankAcc(Database database, BankUser user) {
        super(database, user);
        this.listOfBankUser = database.getListofBankUser();
    }

    @Override
    public void transfer() {
        Scanner sc = new Scanner(System.in);

        boolean isValidAccountNum = false;
        boolean isValidPin = false;
        boolean isValidAmount = false;

        String accountNum = "";

        // Input account number
        while (!isValidAccountNum) {
            System.out.println("Enter account number you want to transfer money to: ");
            accountNum = sc.nextLine();
            String bankAccountRegex = "^\\d{10}$";

            if (accountNum.matches(bankAccountRegex)) {
                isValidAccountNum = true;

                // Input PIN
                while (!isValidPin) {
                    System.out.println("Enter Your Pin: ");
                    int pin = sc.nextInt();

                    if (pin == user.getPin()) {
                        isValidPin = true;
                    } else {
                        System.out.println("Invalid PIN. Please try again.");
                    }
                }

                // Input amount
                while (!isValidAmount) {
                    System.out.println("Enter amount you want to transfer: ");
                    double amount = sc.nextDouble();
                    BankUser bankUserr = (BankUser) this.user;
                    if (bankUserr.bank.checkBalance()) {
                        if (user.inquireBalance() >= amount) {
                            isValidAmount = true;
                            user.setNewBalance(user.inquireBalance() - amount);
                            System.out.println(amount + " transferred successfully to " + accountNum + ". Your balance: " + user.inquireBalance());
                        }
                    } else {
                        System.out.println("Your balance is insufficient. Please try again later.");
                    }
                    for (BankUser bankUser : listOfBankUser) {
                        if (bankUser.getAccountNum().equals(accountNum)) {
                            bankUser.setNewBalance(bankUser.inquireBalance() + amount);
                            System.out.println(amount + " added to: " + bankUser.getAccountNum());
                        }
                    }
                }
            } else {
                System.out.println("Invalid account number. Please try again.");
            }
        }
    }
}