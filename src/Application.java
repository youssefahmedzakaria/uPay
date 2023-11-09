import User.*;

public class Application {

    private UI userInterface;
    private AuthenticationService authenticationService;
    private OTPConfirmation otpConfirmation;


    public Application() {
        this.userInterface = new UI();
        this.authenticationService = new AuthenticationService();
        this.otpConfirmation = new OTPConfirmation();
    }


    public boolean login(String username, String password) {
        // Implement login logic here
        return authenticationService.verifyLogin(username, password);
    }

    public boolean register(String username, String password) {
        // Implement registration logic here
        return authenticationService.verifyRegister(username, password);
    }


    public static void main(String[] args) {
        Application instaPay = new Application();
        instaPay.userInterface.loginMenu();
        System.out.println("ana msh 3aref a3ml eh");

        User userw = new WalletUser("ahmed", "1234", 1000, 1234, User.userType.WalletUser, WalletUser.WalletType.MOBILE_WALLET);
        WalletUser.main(args);

        User userb = new BankUser("ahmed", "1234", 1000, 1234, User.userType.BankUser, "CIB", 123456789, "12/12/2020");
        BankUser.main(args);
    }
}