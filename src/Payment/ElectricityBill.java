package Payment;
import User.*;

public abstract class ElectricityBill extends Bills {
    private double consumedElectricity;

    public ElectricityBill(User user) {
        super(user);
    }
    public void setConsumedElectricity(double consumedElectricity) {this.consumedElectricity = consumedElectricity;}
    public double getConsumedElectricity() {
        return consumedElectricity;
    }

}
