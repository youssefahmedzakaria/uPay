package Payment;
import User.*;

import java.util.Scanner;

public class bankUserGasBill extends GasBill {
    public bankUserGasBill(BankUser user) {
        super(user);
    }

    @Override
    public void payBill() {
        Scanner s = new Scanner(System.in);

        boolean isValidEPaymentCode = false;
        boolean isValidPIN = false;
        boolean hasSufficientBalance = false;
        while (!isValidEPaymentCode) {
            System.out.println("Enter your ePayment code: ");
            String ePaymentCode = s.nextLine();

            double consumedGas = currentRead - prevRead;
            setConsumedGas(consumedGas);

            if (ePaymentCode.equals(this.getePaymentCode())) {
                isValidEPaymentCode = true;

                double bill = this.getConsumedGas() * this.getPrice() + this.getFees();
                System.out.println("Your Gas bill is: " + bill + " L.E");

                while (!isValidPIN) {
                    System.out.println("Enter your pin: ");
                    int pin = s.nextInt();

                    if (pin == user.getPin()) {
                        isValidPIN = true;

                        while (!hasSufficientBalance) {
                            BankUser bankUser = (BankUser) this.user;
                            if (bankUser.bank.checkBalance()) {
                                if (user.inquireBalance() >= bill) {
                                    user.setNewBalance(user.inquireBalance() - bill);
                                    System.out.println("Gas Bill Paid Successfully. Your balance is: " + user.inquireBalance() + " L.E");
                                    hasSufficientBalance = true;
                                } else {
                                    System.out.println("Your balance is insufficient. Try again.");
                                }
                            }
                        }
                    } else {
                        System.out.println("Invalid PIN. Please enter the correct PIN.");
                    }
                }
            } else {
                System.out.println("Invalid ePayment code. Please enter the correct ePayment code.");
            }
        }
    }
    @Override
    public void printBill() {
        // Implementation for printing a gas bill
        System.out.println("Gas Bill Details: ");
        System.out.println("Name: " + this.getName());
        System.out.println("Address: " + this.getAddress());
        System.out.println("Price: " + this.getPrice());
        System.out.println("Fees: " + this.getFees());
        System.out.println("Date: " + this.getDate());
        System.out.println("Previous Read: " + this.getPrevRead());
        System.out.println("Current Read: " + this.getCurrentRead());
        System.out.println("Consumed Gas: " + this.getConsumedGas());
        System.out.println("ePayment Code: " + this.getePaymentCode());
        System.out.println("Your Bill Cost: " + this.getConsumedGas() * this.getPrice() + this.getFees()+" L.E");
    }
}