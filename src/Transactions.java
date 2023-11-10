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
                if (user.getBalance() >= amount) {
                    user.setBalance(user.getBalance() - amount);
                    System.out.println(amount + " transferred successfully to " + mobileNum + ". Your balance: " + user.getBalance());
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
            if (user.getBalance() >= amount) {
                user.setBalance(user.getBalance() - amount);
                System.out.println(amount + " transferred successfully to " + username + ". Your balance: " + user.getBalance());
            } else {
                System.out.println("Your balance is insufficient.");

            }
        }
        else{
            System.out.println("Invalid Pin");
        }
    }

    public static void main(String[] args) {
        User user = new WalletUser("ahmed", "1234", 1000, 1234, User.userType.WalletUser, WalletUser.WalletType.BANK_WALLET);
        Transactions transact = new Transactions(user);
        transact.transferToWalletMobileNum(100, "01111111111", 1234);

    }
}


