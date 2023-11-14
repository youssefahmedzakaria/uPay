package User;

public class WalletUser extends User {

    WalletProvider walletProvider;
    public WalletUser(String username, String password, int phoneNum, int pin, String accountType, WalletProvider walletProvider) {
        super(username, password, phoneNum, pin, accountType);
        this.walletProvider = walletProvider;
    }

    public WalletUser(String username, String password, int phoneNum, int pin, String accountType){
        super(username, password, phoneNum, pin, accountType);
    }


    @Override
    public void changePIN(int newPin) {
        setPin(newPin);
        System.out.println("PIN changed successfully");

    }

    @Override
    public double inquireBalance()  {
        return walletProvider.getBalance();
    }
    @Override
    public void setNewBalance(double newBalance){

        walletProvider.setBalance(newBalance);
    }


    public static void main(String[] args) {

        System.out.println("test wallet class");
    }
}
