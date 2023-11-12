package User;

public class WalletUser extends User {


    public WalletUser(String username, String password, int phoneNum, int pin, String accountType) {
        super(username, password, phoneNum, pin, accountType);
    }


    @Override
    public void changePIN(int newPin) {
        setPin(newPin);
        System.out.println("PIN changed successfully");

    }


    public static void main(String[] args) {
        System.out.println("test wallet class");
    }
}
