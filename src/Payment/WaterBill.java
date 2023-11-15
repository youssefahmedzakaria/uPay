package Payment;

import User.*;

public abstract class WaterBill extends Bills {
    private double consumedWater;

    public WaterBill( User user) {
        super(user);
    }
    public void setConsumedWater(double consumedWater) {this.consumedWater = consumedWater;}

    public double getConsumedWater() {
        return consumedWater;
    }

}
