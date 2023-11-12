package User;

import User.User;

import java.util.ArrayList;

public class WalletUser extends User {
    private WalletType walletId;

    public WalletUser(String username, String password, float balance, int pin, userType userType, WalletType walletId) {
        super(username, password, balance, pin, userType);
        this.walletId = walletId;
    }


    @Override
    public void changePIN(int newPin) {
        setPin(newPin);
        System.out.println("PIN changed successfully");

    }


    @Override
    public void makePayment(double paymentAmount) {
        if (getBalance() >= paymentAmount) {
            setBalance(getBalance() - paymentAmount);
            System.out.println("Payment successful. Remaining balance: " + getBalance());
        } else {
            System.out.println("Insufficient funds for the payment.");
        }
    }

    public WalletType getWalletId() {

        return walletId;
    }

    public void setWalletId(WalletType walletId) {

        this.walletId = walletId;
    }

    public enum WalletType {
        MOBILE_WALLET,
        BANK_WALLET,
        ELECTRONIC_PAYMENT_WALLET
    }

    public static void main(String[] args) {
        System.out.println("test wallet class");
    }
}
