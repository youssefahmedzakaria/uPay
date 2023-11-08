import java.util.Date;

public class ElectricityBill extends Bills {
    private double consumedElectricity;

    public ElectricityBill(String ePaymentCode, String name, String address, float price, float fees, Date date, double prevRead, double currentRead, double consumedElectricity) {
        super(ePaymentCode, name, address, price, fees, date, prevRead, currentRead);
        this.consumedElectricity = consumedElectricity;
    }

    @Override
    public void payBill(String code) {
        // Implementation for paying an electricity bill
    }

    public double getConsumedElectricity() {
        return consumedElectricity;
    }
}
