package Payment;
import App.*;
import User.*;

import java.util.ArrayList;

public abstract class Transferrations {
    protected WalletProvider walletProvider;
    protected Bank bank;
    protected User user;
    protected double amount;

    public Transferrations(Database database, User user, double amount){

        this.user = user;
        this.amount = amount;
    }
    public abstract void transfer();
}
