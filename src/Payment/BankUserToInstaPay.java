package Payment;
import User.*;
import App.*;
import java.util.ArrayList;
import java.util.Scanner;
public class BankUserToInstaPay extends TransferToInstaPayAcc {
    private ArrayList<User> users;

    public BankUserToInstaPay(Database database, BankUser user) {
        super(database, user);
        this.users = database.getListofUser();
    }

    @Override
    public void transfer() {
        String username = "";
        double amount = 0;
        int pin = 0;

        boolean isValidUsername = false;
        boolean isValidAmount = false;
        boolean isValidPin = false;
        Scanner sc = new Scanner(System.in);

        while (!isValidUsername) {
            System.out.println("Enter username you want to transfer money to: ");
            username = sc.nextLine();
            for (User user : users) {
                if (user.getUsername().equals(username)) {
                    isValidUsername = true;
                    break;
                }
            }
            if (isValidUsername) {
                while (!isValidAmount) {
                    System.out.println("Enter amount you want to transfer: ");
                    amount = sc.nextDouble();
                    BankUser bankUser = (BankUser) this.user;
                    if (bankUser.bank.checkBalance()) {
                        if (this.user.inquireBalance() >= amount) {
                            isValidAmount = true;
                        } else {
                            System.out.println("Your balance is insufficient. Enter amount again: ");
                        }
                    } else {
                        System.out.println("Invalid PIN. Enter amount again: ");
                    }
                }
                while (!isValidPin) {
                    System.out.println("Enter Your Pin: ");
                    pin = sc.nextInt();
                    if (pin == this.user.getPin()) {
                        isValidPin = true;
                    } else {
                        System.out.println("Invalid Pin. Try again.");
                    }
                }
                this.user.setNewBalance(this.user.inquireBalance() - amount);

                for (User user : users) {
                    if (user.getUsername().equals(username)) {
                        user.setNewBalance(user.inquireBalance() + amount);
                        System.out.println(amount + " transferred successfully to " + username + ". Your balance: " + this.user.inquireBalance());
                        break;
                    }
                }
            } else {
                System.out.println("Username does not exist. Try again.");
            }
        }
    }
}

