package Payment;
import User.*;
import App.*;

import java.util.ArrayList;
import java.util.Scanner;
public class bankUserToWallet extends TransferToWallet {
    private ArrayList<WalletUser> listOfWalletUser;

    public bankUserToWallet(Database database, User user) {
        super(database, user);
        this.listOfWalletUser = database.getListofWalletUser();
    }

    @Override
    public void transfer() {
        Scanner sc = new Scanner(System.in);

        boolean isValidMobile = false;
        boolean isValidPin = false;
        boolean isValidAmount = false;

        long mobile = 0;
        String mobileNum = "";

        while (!isValidMobile) {
            System.out.println("Enter mobile number you want to transfer money to: ");
            mobileNum = sc.nextLine();
            if (isPhoneValid(mobileNum)) {
                mobile = Long.parseLong(mobileNum);
                isValidMobile = true;
                while (!isValidPin) {
                    System.out.println("Enter Your Pin: ");
                    int pin = sc.nextInt();

                    if (pin == user.getPin()) {
                        isValidPin = true;
                    } else {
                        System.out.println("Invalid PIN. Please try again.");
                    }
                }
                while (!isValidAmount) {
                    System.out.println("Enter amount you want to transfer: ");
                    double amount = sc.nextDouble();
                    BankUser bankUser = (BankUser) this.user;
                    if (bankUser.bank.checkBalance()) {
                        if (user.inquireBalance() >= amount) {
                            isValidAmount = true;
                            for(WalletUser walletUser : listOfWalletUser){
                                if(walletUser.getPhoneNum() == mobile){
                                    walletUser.setNewBalance(walletUser.inquireBalance() + amount);
                                }
                            }
                            System.out.println(amount + " transferred successfully to " + mobileNum + ". Your balance: " +(user.inquireBalance() - amount));
                            this.user.setNewBalance(user.inquireBalance() - amount);
                        } else {
                            System.out.println("Your balance is insufficient. Please try again later.");
                        }
                    }
                }
            } else {
                System.out.println("Invalid mobile number. Please try again.");
            }
        }
    }
}