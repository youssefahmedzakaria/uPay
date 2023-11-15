package Payment;

import User.*;

public abstract class GasBill extends Bills {
    private double consumedGas;

    public GasBill( User user) {
        super( user);
    }

    public void setConsumedGas(double consumedGas) {
        this.consumedGas = consumedGas;
    }

    public double getConsumedGas() {
        return consumedGas;
    }
}