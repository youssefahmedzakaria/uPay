package Payment;
import User.*;
import App.*;

public abstract class TransferToInstaPayAcc extends Transferrations{

        public TransferToInstaPayAcc(Database database, User user) {
            super(database, user);
        }
}
