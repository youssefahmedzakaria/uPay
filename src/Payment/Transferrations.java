package Payment;
import App.*;
import User.*;

import java.util.ArrayList;
import java.util.Scanner;

public abstract class Transferrations {
    protected WalletProvider walletProvider;
    protected Bank bank;
    protected User user;

    public Transferrations(Database database, User user){
        this.user = user;
    }
    public abstract void transfer();
}
