package App;
import Payment.*;
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

    }
}