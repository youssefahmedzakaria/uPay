package Payment;

import java.util.Date;
import java.util.Scanner;

import Payment.Bills;
import User.*;

public class ElectricityBill extends Bills {
    private double consumedElectricity;

    public ElectricityBill( String name, String address, float price, float fees, Date date, double prevRead, double currentRead, double consumedElectricity, User user) {
        super(name, address, price, fees, date, prevRead, currentRead, user);
        this.consumedElectricity = consumedElectricity;
    }
    public void setConsumedElectricity(double consumedElectricity) {this.consumedElectricity = consumedElectricity;}
    @Override
    public void payBill(){
        // Implementation for paying a gas bill
        System.out.println("Enter your ePayment code: ");
        Scanner s  = new Scanner(System.in);
        String ePaymentCode = s.nextLine();
        double consumedElectricity = currentRead - prevRead;
        setConsumedElectricity(consumedElectricity);
        if(ePaymentCode == this.getePaymentCode()){
            double bill = this.getConsumedElectricity() * this.getPrice() + this.getFees();
            System.out.println("Your electricity bill is: " + bill);
            System.out.println("Enter your pin: ");
            int pin = s.nextInt();
            if(pin == user.getPin()){
                if(user.getBalance() >= bill ){
                    user.setBalance(user.getBalance() - bill);
                    System.out.println("Electricity Bill Paid Successfully. Your balance is: " + user.getBalance());
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
        System.out.println("Electricity Bill Details: ");
        System.out.println("Name: " + this.getName());
        System.out.println("Address: " + this.getAddress());
        System.out.println("Price: " + this.getPrice());
        System.out.println("Fees: " + this.getFees());
        System.out.println("Date: " + this.getDate());
        System.out.println("Previous Read: " + this.getPrevRead());
        System.out.println("Current Read: " + this.getCurrentRead());
        System.out.println("Consumed Electricity: " + this.getConsumedElectricity());
    }
    public double getConsumedElectricity() {
        return consumedElectricity;
    }
}
