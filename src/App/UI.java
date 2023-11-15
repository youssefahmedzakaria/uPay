package App;
import User.*;
import Payment.*;

import java.util.Scanner;

public class UI {
    public  Database database;
    public static User currentUser=new User();

    public UI(){
        database=new Database();
    }
    public User loginMenu() {
        String  username,pass;
        Scanner in=new Scanner(System.in);
        boolean loginValid=true;
        do {
            loginValid=true;
            System.out.println("Enter your username");
            username=in.nextLine();
            System.out.println("Enter your password");
            pass=in.nextLine();

            Login login=new Login(database.getListofUser());
            if (login.verifyLogin(username,pass)){
                User logedUser= database.getUser(username);
                return logedUser;
            }else{
                System.out.println("Failed username or password, Try again!");
                loginValid=false;
            }
            }while (!loginValid);
        return null;
    }

    public void registerMenu(){
        Register register=new Register(database);
        register.verifyRegister();
    }

    public void mainMenu() {
        Scanner in = new Scanner(System.in);
        int choose;

        do {
            System.out.println("1-Login\n2-Register\n3-Exit");
            choose = in.nextInt();

            if (choose == 1) {
                this.currentUser = loginMenu();
            } else if (choose == 2) {
                registerMenu();
                this.currentUser = loginMenu();
            } else if (choose == 3) {
                System.exit(0);
            } else {
                System.out.println("Invalid Input, Try Again!");
            }

            if (this.currentUser != null) {
                // If a user is logged in, call the appropriate menu
                if (this.currentUser instanceof BankUser) {
                    bankUserMenu();
                } else if (this.currentUser instanceof WalletUser) {
                    walletUserMenu();
                }
            }
        } while (choose != 3);
    }


    public void bankUserMenu() {
        Scanner in = new Scanner(System.in);
        int choose;
        do {
            System.out.println("-------------------------------");
            System.out.println("1-Transfer to Bank Account");
            System.out.println("2-Transfer to Wallet");
            System.out.println("3-Transfer to InstaPay Account");
            System.out.println("4-Pay Bills");
            System.out.println("5-Inquire Balance");
            System.out.println("6-Log Out");
            choose = in.nextInt();

            if (choose == 1) {
                BankUser bankUser = (BankUser) currentUser;
                TransferToBankAcc transferToBankAcc = new TransferToBankAcc(database, bankUser);
                transferToBankAcc.transfer();
            } else if (choose == 2) {
                TransferToWallet transferToWallet = new bankUserToWallet(database, currentUser);
                transferToWallet.transfer();
            } else if (choose == 3) {
                BankUser bankUser = (BankUser) currentUser;
                TransferToInstaPayAcc transferToInstapayAcc = new BankUserToInstaPay(database, bankUser);
                transferToInstapayAcc.transfer();
            } else if (choose == 4) {
                billsMenu();
            } else if (choose == 5) {
                BankUser bankUser = (BankUser) currentUser;
                System.out.println("Your balance is : " + bankUser.inquireBalance() + " L.E");
            } else if (choose == 6) {
                this.currentUser = null;
            }else{
                System.out.println("Invalid Input, Try Again!");
            }
        }while (choose!=6);
    }


    public void walletUserMenu() {
        Scanner in=new Scanner(System.in);
        int choose;
        do {
                System.out.println("-------------------------------");
                System.out.println("1-Transfer to Wallet");
                System.out.println("2-Transfer to InstaPay Account");
                System.out.println("3-Pay Bills");
                System.out.println("4-Inquire Balance");
                System.out.println("5-Log Out");
                choose = in.nextInt();

                if (choose == 1) {
                    WalletUser walletUser = (WalletUser) currentUser;
                    TransferToWallet transferToWallet = new walletuserToWallet(database, currentUser);
                    transferToWallet.transfer();
                } else if (choose == 2) {
                    WalletUser walletUser = (WalletUser) currentUser;
                    TransferToInstaPayAcc transferToInstapayAcc = new WalletUserToInstapay(database, currentUser);
                    transferToInstapayAcc.transfer();
                } else if (choose == 3) {
                    billsMenu();
                } else if (choose == 4) {
                    WalletUser walletUser = (WalletUser) currentUser;
                    System.out.println("Your balance is : " + walletUser.inquireBalance() + " L.E");
                } else if (choose == 5) {
                    this.currentUser = null;
                }
        }while (choose!=5);
    }

    public void billsMenu() {
        Scanner in = new Scanner(System.in);
        int choose;
        System.out.println("Enter the bill you want to pay:");
        System.out.println("1-Gas Bill\n2-Water Bill\n3-Electricity Bills");
        choose = in.nextInt();

        if (choose == 1) {
            if(currentUser instanceof  BankUser) {
                BankUser bankUser = (BankUser) currentUser;
                Bills gasBill = new bankUserGasBill(bankUser);
                gasBill.payingBill();
            }else if(currentUser instanceof  WalletUser){
                WalletUser walletUser = (WalletUser) currentUser;
                Bills gasBill = new walletUserGasBill(walletUser);
                gasBill.payingBill();
            }
        } else if (choose == 2) {
            if(currentUser instanceof  BankUser) {
                BankUser bankUser = (BankUser) currentUser;
                Bills waterBill = new bankUserWaterBill(bankUser);
                waterBill.payingBill();
            }else if(currentUser instanceof  WalletUser){
                WalletUser walletUser = (WalletUser) currentUser;
                Bills waterBill = new walletUserWaterBill(walletUser);
                waterBill.payingBill();
            }
        } else if (choose == 3) {
            if(currentUser instanceof  BankUser) {
                BankUser bankUser = (BankUser) currentUser;
                Bills elecBill = new bankUserElecBill(bankUser);
                elecBill.payingBill();
            }else if(currentUser instanceof  WalletUser){
                WalletUser walletUser = (WalletUser) currentUser;
                Bills elecBill = new walletUserElecBill(walletUser);
                elecBill.payingBill();
            }
        }
    }
    public User getCurrentUser(){
        return currentUser;
    }
}
