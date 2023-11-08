import java.util.Date;

public class WaterBill extends Bills {
    private double consumedWater;

    public WaterBill(String ePaymentCode, String name, String address, float price, float fees, Date date, double prevRead, double currentRead, double consumedWater) {
        super(ePaymentCode, name, address, price, fees, date, prevRead, currentRead);
        this.consumedWater = consumedWater;
    }

    @Override
    public void payBill(String code) {
        // Implementation for paying a water bill
    }

    public double getConsumedWater() {
        return consumedWater;
    }

}
