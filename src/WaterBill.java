import java.util.Date;
import java.util.Random;
import java.util.Scanner;
import User.*;

public class WaterBill extends Bills {
    private double consumedWater;

    public WaterBill( String name, String address, float price, float fees, Date date, double prevRead, double currentRead, double consumedWater, User user) {
        super( name, address, price, fees, date, prevRead, currentRead, user);
        this.consumedWater = consumedWater;
    }
    public void setConsumedWater(double consumedWater) {this.consumedWater = consumedWater;}

    @Override
    public void getePaymentCode(double prevRead, double currentRead){
        // Implementation for getting an ePayment code
        setPrevRead(prevRead);
        setCurrentRead(currentRead);
        double consumedWater = currentRead - prevRead;
        setConsumedWater(consumedWater);
        String ePaymentCode = "EG" + (int) (Math.random() * 1000000);
        setePaymentCode(ePaymentCode);
        System.out.println("ePayment code: " + ePaymentCode);
    }

    @Override
    public void payBill() {
        // Implementation for paying a water bill
        System.out.println("Enter your ePayment code: ");
        Scanner s  = new Scanner(System.in);
        String ePaymentCode = s.nextLine();
        if(ePaymentCode == this.getePaymentCode()){
            double bill = this.getConsumedWater() * this.getPrice() + this.getFees();
            System.out.println("Your Water bill is: " + bill);
            System.out.println("Enter your pin: ");
            int pin = s.nextInt();
            if(pin == user.getPin()){
                if(user.getBalance() >= bill ){
                    user.setBalance(user.getBalance() - bill);
                    System.out.println("Water Bill Paid Successfully. Your balance is: " + user.getBalance());
                }
                else{
                    System.out.println("Your balance is insufficient.");
                }
            }
        }
        else{
            System.out.println("Invalid ePayment code.");
        }

    }

    public double getConsumedWater() {
        return consumedWater;
    }

}
