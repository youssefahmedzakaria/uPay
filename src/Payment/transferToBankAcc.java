package Payment;
import User.*;
import App.*;
import java.util.ArrayList;
import java.util.Scanner;

public class transferToBankAcc extends Transferrations {
    private ArrayList<BankUser> listOfBankUser;

    // Constructor for Payment.BankTransactions class
    public transferToBankAcc(Database database, BankUser user, double amount) {
        super(database, user, amount);
        this.listOfBankUser = database.getListofBankUser();
    }
    @Override
    public void transfer(){
        System.out.println("Enter account number you want to transfer money to: ");
        Scanner sc = new Scanner(System.in);
        String accountNum = sc.nextLine();
        String bankAccountRegex = "^\\d{10}$";
        if(accountNum.matches(bankAccountRegex)){
            System.out.println("Enter Your Pin: ");
            int pin = sc.nextInt();
            if (pin == user.getPin()) {
                if (user.inquireBalance() >= amount) {
                    user.setNewBalance(user.inquireBalance() - amount);
                    for (BankUser bankUser : listOfBankUser) {
                        if (bankUser.getAccountNum().equals(accountNum)) {
                            bankUser.setNewBalance(bankUser.inquireBalance() + amount);
                            System.out.println(amount + " added to: " + bankUser.getAccountNum());
                        }
                    }
                    System.out.println(amount + " transferred successfully to " + accountNum + ". Your balance: " + user.inquireBalance());
                } else {
                    System.out.println("Your balance is insufficient.");
                }
            } else {
                System.out.println("Invalid Pin");
            }
        }
        else {
            System.out.println("Account Number is invalid");
        }
    }
    public static void main(String[] args) {
        Database database = new Database();
        //Register register = new Register(database);
        //register.verifyRegister();
        User user = new BankUser("username", "password", 123456789, 1234, "bank", "123456789", "12/12/2020", "123456789", new Bank("bank", 100000));
        Transferrations bankTransfer = new transferToBankAcc(database, (BankUser) user, 100);
        bankTransfer.transfer();
    }
}