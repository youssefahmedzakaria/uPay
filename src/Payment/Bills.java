package Payment;

import java.util.Date;
import User.*;

public abstract class Bills {
    protected String ePaymentCode;
    protected String name;
    protected String address;
    protected float price;
    protected float fees;
    protected Date date;
    protected double prevRead;
    protected double currentRead;
    protected User user;
    public Bills( String name, String address, float price, float fees, Date date, double prevRead, double currentRead, User user) {
        this.name = name;
        this.address = address;
        this.price = price;
        this.fees = fees;
        this.date = date;
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

    public void generateEPaymentCode(double prevRead, double currentRead){
        // Implementation for getting an ePayment code
        setPrevRead(prevRead);
        setCurrentRead(currentRead);
        String ePaymentCode = "EG" + (int) (Math.random() * 1000000);
        setePaymentCode(ePaymentCode);
        System.out.println("ePayment code: " + ePaymentCode);
    }
    final void payingBill(){
        generateEPaymentCode(prevRead, currentRead);
        payBill();
        printBill();
    }
    public abstract void payBill();
    public abstract void printBill();



}
