import java.util.Date;

public class GasBill extends Bills {
    private double consumedGas;

    public GasBill(String ePaymentCode, String name, String address, float price, float fees, Date date, double prevRead, double currentRead, double consumedGas) {
        super(ePaymentCode, name, address, price, fees, date, prevRead, currentRead);
        this.consumedGas = consumedGas;
    }

    @Override
    public void payBill(String code) {
        // Implementation for paying a gas bill
    }

    public double getConsumedGas() {
        return consumedGas;
    }
}
