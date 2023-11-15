package Payment;
import User.*;
import App.*;

import java.util.ArrayList;
import java.util.Scanner;

public class TransferToInstapayAcc extends Transferrations {
    private ArrayList<User> users;

    public TransferToInstapayAcc(Database database, User user) {
        super(database, user);
        this.users = database.getListofUser();
    }

    public void transfer() {
        System.out.println("Enter username you want to transfer money to: ");
        Scanner sc = new Scanner(System.in);
        String username = sc.nextLine();
        double amount;
        for (User user : users) {
            if (user.getUsername().equals(username)) {
                System.out.println("Enter Your Pin: ");
                int pin = sc.nextInt();
                if (pin ==this.user.getPin()) {
                    if (user.getAccountType().equals("Bank")) {   ///----------BEGIN
                        BankUser bankUser = (BankUser) this.user;
                        if (bankUser.bank.checkBalance()) {
                            System.out.println("Enter amount you want to transfer: ");
                            amount = sc.nextDouble();
                            if (this.user.inquireBalance() >= amount) {
                                this.user.setNewBalance(this.user.inquireBalance() - amount);
                                user.setNewBalance(user.inquireBalance() + amount);
                                System.out.println(amount + " transferred successfully to " + username + ". Your balance: " + this.user.inquireBalance());
                                break;
                            } else {
                                System.out.println("Your balance is insufficient.");
                            }
                        }
                    }
                    ////////////////---------------------------------------------------------
                    else if (user.getAccountType().equals("Wallet")) {   ///----------BEGIN
                        WalletUser walletUser = (WalletUser) this.user;
                        if (walletUser.walletProvider.checkBalance()) {
                            System.out.println("Enter amount you want to transfer: ");
                            amount = sc.nextDouble();
                            if (this.user.inquireBalance() >= amount) {
                                this.user.setNewBalance(this.user.inquireBalance() - amount);
                                user.setNewBalance(user.inquireBalance() + amount);
                                System.out.println(amount + " transferred successfully to " + username + ". Your balance: " + this.user.inquireBalance());
                                break;
                            } else {
                                System.out.println("Your balance is insufficient.");
                            }
                        } else {
                            System.out.println("Invalid Pin");
                        }
                    } else {
                        System.out.println("Username does not exist.");
                    }
                }
            }
        }
    }
}
