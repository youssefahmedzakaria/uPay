package Payment;

import java.util.Date;
import java.util.Scanner;

import Payment.Bills;
import User.*;

public class WaterBill extends Bills {
    private double consumedWater;

    public WaterBill( String name, String address, float price, float fees, Date date, double prevRead, double currentRead, double consumedWater, User user) {
        super( name, address, price, fees, date, prevRead, currentRead, user);
        this.consumedWater = consumedWater;
    }
    public void setConsumedWater(double consumedWater) {this.consumedWater = consumedWater;}

    @Override
    public void payBill() {
        // Implementation for paying a water bill
        System.out.println("Enter your ePayment code: ");
        Scanner s  = new Scanner(System.in);
        String ePaymentCode = s.nextLine();
        double consumedWater = currentRead - prevRead;
        setConsumedWater(consumedWater);
        if(ePaymentCode == this.getePaymentCode()){
            double bill = this.getConsumedWater() * this.getPrice() + this.getFees();
            System.out.println("Your Water bill is: " + bill);
            System.out.println("Enter your pin: ");
            int pin = s.nextInt();
            if(pin == user.getPin()){
                if(user.inquireBalance() >= bill ){
                    user.setNewBalance(user.inquireBalance() - bill);
                    System.out.println("Water Bill Paid Successfully. Your balance is: " + user.inquireBalance());
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
    @Override
    public void printBill(){
        // Implementation for printing a water bill
        System.out.println("Water Bill Details: ");
        System.out.println("Name: " + this.getName());
        System.out.println("Address: " + this.getAddress());
        System.out.println("Price: " + this.getPrice());
        System.out.println("Fees: " + this.getFees());
        System.out.println("Date: " + this.getDate());
        System.out.println("Previous Read: " + this.getPrevRead());
        System.out.println("Current Read: " + this.getCurrentRead());
        System.out.println("Consumed Water: " + this.getConsumedWater());
    }

    public double getConsumedWater() {
        return consumedWater;
    }

}
