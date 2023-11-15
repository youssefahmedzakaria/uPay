package Payment;

import java.util.Date;
import java.util.Random;
import java.util.Scanner;

import User.*;

public abstract class Bills {
    protected String ePaymentCode;
    protected String name;
    protected String address;
    protected float price; //
    protected float fees;  //
    protected Date date;
    protected double prevRead; //
    protected double currentRead; //
    protected User user;
    public Bills(User user) {
        this.name = "Alaa Ahmed El-Gendy";
        this.address = "15 May City - Helwan";
        this.price = 5.25f;
        this.fees = 7;
        this.date = new Date();
        this.prevRead = prevRead;
        this.currentRead = currentRead;
        this.user = user;
    }
    public void setName(String name) {this.name = name;}
    public void setePaymentCode(String ePaymentCode) {this.ePaymentCode = ePaymentCode;}
    public String getePaymentCode() {return ePaymentCode;}
    public void setAddress(String address) {this.address = address;}
    public void setPrice(float price) {this.price = price;}
    public void setFees(float fees) {this.fees = fees;}
    public void setDate(Date date) {this.date = date;}
    public void setPrevRead(double prevRead) {this.prevRead = prevRead;}
    public void setCurrentRead(double currentRead) {this.currentRead = currentRead;}
    public String getName() {return name;}
    public String getAddress() {return address;}
    public float getPrice() {return price;}
    public float getFees() {return fees;}
    public Date getDate() {return date;}
    public double getPrevRead() {return prevRead;}
    public double getCurrentRead() {return currentRead;}

    public void generateEPaymentCode(){
        Scanner in=new Scanner(System.in);
        double prevRead,currentRead;
        boolean isValid;
        do {
            isValid=true;
            System.out.println("Enter your previous read");
            prevRead = in.nextFloat();
            System.out.println("Enter your current read");
            currentRead = in.nextFloat();
            if(currentRead<prevRead){
                isValid=false;
                System.out.println("Your current read must be greater than your previous read, Enter valid input");
            }
        }while (!isValid);
        this.setCurrentRead(currentRead);
        this.setPrevRead(prevRead);

        // Implementation for getting an ePayment code
        setPrevRead(prevRead);
        setCurrentRead(currentRead);
        String ePaymentCode = "EG" + (int) (Math.random() * 1000000);
        setePaymentCode(ePaymentCode);
        System.out.println("ePayment code: " + ePaymentCode);
    }
    public final void payingBill(){
        generateEPaymentCode();
        payBill();
        printBill();
    }
    public abstract void payBill();
    public abstract void printBill();



}
