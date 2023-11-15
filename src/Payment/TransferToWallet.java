package Payment;
import User.*;
import App.*;

import java.util.ArrayList;
import java.util.Scanner;

public abstract class TransferToWallet extends Transferrations {
    private ArrayList<WalletUser> listOfWalletUser;

    public TransferToWallet(Database database, User user) {
        super(database, user);
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
                System.out.println("Enter amount you want to transfer: ");
                double amount = sc.nextDouble();
                if (user.getAccountType().equals("Bank")) {
                    BankUser bankUser = (BankUser) this.user;
                    if (bankUser.bank.checkBalance()) {
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
                } else if (user.getAccountType().equals("Wallet")) {
                    WalletUser walletUser1 = (WalletUser) this.user;
                    if (walletUser1.walletProvider.checkBalance()) {
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
                            System.out.println("Your balance is insufficient. Please try again.");
                        }
                    } else {
                        System.out.println("Invalid Pin. please try again.");
                    }
                } else {
                    System.out.println("Invalid mobile number. Please try again.");
                }
            }
        }
    }

    public static void main(String[] args) {

    }
}