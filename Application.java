public class Application {

    private UI userInterface;
    private AuthenticationService authenticationService;
    private OTPConfirmation otpConfirmation;


    public Application() {
        this.userInterface = new UI();
        this.authenticationService = new AuthenticationService();
        this.otpConfirmation = new OTPConfirmation();
    }

    // Methods
    public boolean login(String username, String password) {
        // Implement login logic here
        return authenticationService.verifyLogin(username, password);
    }

    public boolean register(String username, String password) {
        // Implement registration logic here
        return authenticationService.verifyRegister(username, password);
    }


    public static void main(String[] args) {
//        instaPay instaPay = new instaPay();
//        instaPay.userInterface.loginMenu();
        System.out.println("ana msh 3aref a3ml eh");
    }


}
