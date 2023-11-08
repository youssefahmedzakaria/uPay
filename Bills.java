import java.util.Date;

public abstract class Bills {
    protected String ePaymentCode;
    protected String name;
    protected String address;
    protected float price;
    protected float fees;
    protected Date date;
    protected double prevRead;
    protected double currentRead;

    public Bills(String ePaymentCode, String name, String address, float price, float fees, Date date, double prevRead, double currentRead) {
        this.ePaymentCode = ePaymentCode;
        this.name = name;
        this.address = address;
        this.price = price;
        this.fees = fees;
        this.date = date;
        this.prevRead = prevRead;
        this.currentRead = currentRead;
    }

    public abstract void payBill(String code);


}
