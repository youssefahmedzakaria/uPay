import java.util.Date;
import java.util.Scanner;
import User.*;

public class GasBill extends Bills {
    private double consumedGas;

    public GasBill( String name, String address, float price, float fees, Date date, double prevRead, double currentRead, double consumedGas, User user) {
        super( name, address, price, fees, date, prevRead, currentRead, user);
        this.consumedGas = consumedGas;
    }
    public void setConsumedGas(double consumedGas) {this.consumedGas = consumedGas;}
    public double getConsumedGas() {
        return consumedGas;
    }
    @Override
    public void getePaymentCode(double prevRead, double currentRead){
        // Implementation for getting an ePayment code
        setPrevRead(prevRead);
        setCurrentRead(currentRead);
        double consumedGas = currentRead - prevRead;
        setConsumedGas(consumedGas);
        String ePaymentCode = "EG" + (int) (Math.random() * 1000000);
        setePaymentCode(ePaymentCode);
        System.out.println("ePayment code: " + ePaymentCode);
    }

    @Override
    public void payBill(){
    // Implementation for paying a gas bill
        System.out.println("Enter your ePayment code: ");
        Scanner s  = new Scanner(System.in);
        String ePaymentCode = s.nextLine();
        if(ePaymentCode.equals(this.getePaymentCode())){
            double bill = this.getConsumedGas() * this.getPrice() + this.getFees();
            System.out.println("Your gas bill is: " + bill);
            System.out.println("Enter your pin: ");
            int pin = s.nextInt();
            if(pin == user.getPin()){
                if(user.getBalance() >= bill ){
                    user.setBalance(user.getBalance() - bill);
                    System.out.println("Gas Bill Paid Successfully. Your balance is: " + user.getBalance());
                }
                else{
                    System.out.println("Your balance is insufficient.");
                }
            }
            else{
                System.out.println("Invalid Pin");
            }
        }
        else{
            System.out.println("Invalid ePayment code.");
        }
    }

    public static void main(String[] args){
        User user = new WalletUser("ahmed", "1234", 100000, 1234, User.userType.WalletUser, WalletUser.WalletType.BANK_WALLET);
        GasBill gasBill = new GasBill("Ahmed", "Cairo", 100, 10, new Date(), 100, 200, 100, user);
        gasBill.getePaymentCode(100, 200);
        gasBill.payBill();
    }
}
