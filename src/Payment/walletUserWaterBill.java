package Payment;
import User.*;

import java.util.Scanner;

public class walletUserWaterBill extends WaterBill {
    public walletUserWaterBill(WalletUser user) {
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

            double consumedWater = currentRead - prevRead;
            setConsumedWater(consumedWater);

            if (ePaymentCode.equals(this.getePaymentCode())) {
                isValidEPaymentCode = true;

                double bill = this.getConsumedWater() * this.getPrice() + this.getFees();
                System.out.println("Your Water bill is: " + bill + " L.E");

                while (!isValidPIN) {
                    System.out.println("Enter your pin: ");
                    int pin = s.nextInt();

                    if (pin == user.getPin()) {
                        isValidPIN = true;

                        while (!hasSufficientBalance) {
                            WalletUser walletUser = (WalletUser) this.user;
                            if (walletUser.walletProvider.checkBalance()) {
                                if (user.inquireBalance() >= bill) {
                                    user.setNewBalance(user.inquireBalance() - bill);
                                    System.out.println("Water Bill Paid Successfully. Your balance is: " + user.inquireBalance() + " L.E");
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
        System.out.println("Your Bill Cost: " + this.getConsumedWater() * this.getPrice() + this.getFees()+" L.E");
    }
}
