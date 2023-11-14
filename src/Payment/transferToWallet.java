package Payment;
import User.*;
import App.*;

import java.util.ArrayList;
import java.util.Scanner;

public class transferToWallet extends Transferrations {
    private ArrayList<WalletUser> listOfWalletUser;

    transferToWallet(Database database, User user, double amount) {
        super(database, user, amount);
        this.listOfWalletUser = database.getListofWalletUser();

    }

    public boolean isPhoneValid(String phone) {
        String regex = "^(010|011|012|015)\\d{8}$";

        if (phone.matches(regex)) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void transfer() {
        System.out.println("Enter mobile number you want to transfer money to: ");
        Scanner sc = new Scanner(System.in);
        String mobileNum = sc.nextLine();
        long mobile = Integer.parseInt(mobileNum);
        if (isPhoneValid(mobileNum)) {
            System.out.println("Enter Your Pin: ");
            int pin = sc.nextInt();
            if (pin == user.getPin()) {
                if (bank.checkBalance() || walletProvider.checkBalance()) {
                    if (user.inquireBalance() >= amount) {
                        user.setNewBalance(user.inquireBalance() - amount);
                        for (WalletUser walletUser : listOfWalletUser) {
                            if (walletUser.getPhoneNum() == mobile) {
                                walletUser.setNewBalance(walletUser.inquireBalance() + amount);
                                System.out.println(amount + " added to: " + walletUser.getPhoneNum());
                            }
                        }
                        System.out.println(amount + " transferred successfully to " + mobileNum + ". Your balance: " + user.inquireBalance());
                    } else {
                        System.out.println("Your balance is insufficient.");
                    }
                } else {
                    System.out.println("Invalid Pin");
                }
            } else {
                System.out.println("Invalid mobile number");
            }
        }
    }

    public static void main(String[] args) {
     Database database = new Database();
     WalletProvider w = new MobileWallet(10000, "mobileWallet", "vodafone");
     User user = new WalletUser("username", "password", 01123345565, 1234, "wallet",w);
     Transferrations t = new transferToWallet(database, user, 100);
     t.transfer();
    }
}