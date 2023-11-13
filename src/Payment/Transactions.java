package Payment;

import User.*;
public class Transactions {
    User user;
    public Transactions(User user) {
        this.user = user;
    }

    // Method to transfer to wallet/mobile number
    public void transferToWalletMobileNum(double amount, String mobileNum, int pin) {
        // Logic to transfer amount to a wallet/mobile number
        if (pin == user.getPin()) {
            if (mobileNum.charAt(0) == '0' && mobileNum.charAt(1) == '1' && mobileNum.length() == 11) {
                if (user.inquireBalance() >= amount) {
                    user.setNewBalance(user.inquireBalance() - amount);
                    System.out.println(amount + " transferred successfully to " + mobileNum + ". Your balance: " + user.inquireBalance());
                } else {
                    System.out.println("Your balance is insufficient.");
                }
            } else {
                System.out.println("Invalid mobile number");
            }
        }
        else{
            System.out.println("Invalid Pin");
        }
    }

    // Method to transfer to a payee's account
    public void transferToInstaPayAccount(double amount, String username, int pin) {
        // Logic to transfer amount to a payee's account
        if (pin == user.getPin()) {
            if (user.inquireBalance() >= amount) {
                user.setNewBalance(user.inquireBalance() - amount);
                System.out.println(amount + " transferred successfully to " + username + ". Your balance: " + user.inquireBalance());
            } else {
                System.out.println("Your balance is insufficient.");

            }
        }
        else{
            System.out.println("Invalid Pin");
        }
    }

    public static void main(String[] args) {
        User user = new BankUser("username", "password", 123456789, 1234, "bank", "123456789", "12/12/2020", "123456789", new Bank("bank", 100000));
        Transactions transact = new Transactions(user);
        transact.transferToWalletMobileNum(100, "01111111111", 1234);

    }
}


