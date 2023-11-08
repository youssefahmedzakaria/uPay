public class WalletUser extends User {

    private WalletType walletId;

    public WalletUser(String username, String password, float balance, int pin, WalletType walletId) {
        super(username, password, balance, pin); // Assuming the superclass User has this constructor
        this.walletId = walletId;
    }

    @Override
    public void changePIN(int newPin) {
        // Code to change the PIN for a wallet user
    }

    // Method to process a payment
    @Override
    public void makePayment() {
        // Code to process a payment for a wallet user
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
}
