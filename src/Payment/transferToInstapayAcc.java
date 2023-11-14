package Payment;
import User.*;
import App.*;

import java.util.ArrayList;
import java.util.Scanner;

public class transferToInstapayAcc extends Transferrations {
    private ArrayList<User> users;

    public transferToInstapayAcc(Database database, User user, double amount) {
        super(database, user, amount);
        this.users = database.getListofUser();
    }

    public void transfer() {
        System.out.println("Enter username you want to transfer money to: ");
        Scanner sc = new Scanner(System.in);
        String username = sc.nextLine();
        for (User user : users) {
            if (user.getUsername().equals(username)) {
                System.out.println("Enter Your Pin: ");
                int pin = sc.nextInt();
                if (pin == user.getPin()) {
                    if (bank.checkBalance() || walletProvider.checkBalance()) {
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
