import App.*;
import Payment.*;
import User.*;

public class InstaPay {
    public UI ui;

    public InstaPay(){
        this.ui=new UI();
        while (true) {
            ui.mainMenu();
            if (ui.getCurrentUser().getAccountType().equals("Bank"))
                ui.bankUserMenu();
            else if (ui.getCurrentUser().getAccountType().equals("Wallet"))
                ui.walletUserMenu();
        }
    }


    public static void main(String[] args) {
        InstaPay instaPay=new InstaPay();
    }
}
