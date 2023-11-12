package App;

import java.text.DecimalFormat;
import java.util.Random;

public class OTPConfirmation {

    public String OTPGenerator() {
        String otp = new DecimalFormat("000000").format(new Random().nextInt(999999));
        return otp;
    }

    public boolean sendOTP() {
        String otp = OTPGenerator();
        return false;
    }

    public boolean verifyOTP(String otp) {
        return false;
    }


}
